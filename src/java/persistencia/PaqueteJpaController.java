package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Paquete;
import persistencia.exceptions.NonexistentEntityException;

public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PaqueteJpaController(){
        emf = Persistence.createEntityManagerFactory("TPFinal_PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) {
        if (paquete.getLista_servicios_incluidos() == null) {
            paquete.setLista_servicios_incluidos(new ArrayList<Servicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedLista_servicios_incluidos = new ArrayList<Servicio>();
            for (Servicio lista_servicios_incluidosServicioToAttach : paquete.getLista_servicios_incluidos()) {
                lista_servicios_incluidosServicioToAttach = em.getReference(lista_servicios_incluidosServicioToAttach.getClass(), lista_servicios_incluidosServicioToAttach.getCodigo_servicio());
                attachedLista_servicios_incluidos.add(lista_servicios_incluidosServicioToAttach);
            }
            paquete.setLista_servicios_incluidos(attachedLista_servicios_incluidos);
            em.persist(paquete);
            for (Servicio lista_servicios_incluidosServicio : paquete.getLista_servicios_incluidos()) {
                lista_servicios_incluidosServicio.getLista_paquetes().add(paquete);
                lista_servicios_incluidosServicio = em.merge(lista_servicios_incluidosServicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getCodigo_paquete());
            List<Servicio> lista_servicios_incluidosOld = persistentPaquete.getLista_servicios_incluidos();
            List<Servicio> lista_servicios_incluidosNew = paquete.getLista_servicios_incluidos();
            List<Servicio> attachedLista_servicios_incluidosNew = new ArrayList<Servicio>();
            for (Servicio lista_servicios_incluidosNewServicioToAttach : lista_servicios_incluidosNew) {
                lista_servicios_incluidosNewServicioToAttach = em.getReference(lista_servicios_incluidosNewServicioToAttach.getClass(), lista_servicios_incluidosNewServicioToAttach.getCodigo_servicio());
                attachedLista_servicios_incluidosNew.add(lista_servicios_incluidosNewServicioToAttach);
            }
            lista_servicios_incluidosNew = attachedLista_servicios_incluidosNew;
            paquete.setLista_servicios_incluidos(lista_servicios_incluidosNew);
            paquete = em.merge(paquete);
            for (Servicio lista_servicios_incluidosOldServicio : lista_servicios_incluidosOld) {
                if (!lista_servicios_incluidosNew.contains(lista_servicios_incluidosOldServicio)) {
                    lista_servicios_incluidosOldServicio.getLista_paquetes().remove(paquete);
                    lista_servicios_incluidosOldServicio = em.merge(lista_servicios_incluidosOldServicio);
                }
            }
            for (Servicio lista_servicios_incluidosNewServicio : lista_servicios_incluidosNew) {
                if (!lista_servicios_incluidosOld.contains(lista_servicios_incluidosNewServicio)) {
                    lista_servicios_incluidosNewServicio.getLista_paquetes().add(paquete);
                    lista_servicios_incluidosNewServicio = em.merge(lista_servicios_incluidosNewServicio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete.getCodigo_paquete();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getCodigo_paquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> lista_servicios_incluidos = paquete.getLista_servicios_incluidos();
            for (Servicio lista_servicios_incluidosServicio : lista_servicios_incluidos) {
                lista_servicios_incluidosServicio.getLista_paquetes().remove(paquete);
                lista_servicios_incluidosServicio = em.merge(lista_servicios_incluidosServicio);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paquete findPaquete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

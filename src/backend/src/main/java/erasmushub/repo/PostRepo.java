package erasmushub.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
	// JPQL: Cerca un post tramite id
	@Query("SELECT p FROM Post p WHERE p.id = ?1")
	Post findById(int id);

	// JPQL: Elimina un post tramite id
	@Modifying
	@Query("DELETE FROM Post p WHERE p.id = ?1")
	int deleteById(int id);

	// JPQL: Aggiorna un post tramite il suo id
	@Modifying
	@Query("UPDATE Post p SET id_associazione = :id_associazione, img = :img, nome = :nome, descrizione = :descrizione, "
			+ "data_pubblicazione = :data_pubblicazione, data_evento = :data_evento WHERE p.id = :id")
	int updatePost(@Param("id_associazione") int id_associazione, @Param("img") String img, @Param("nome") String nome,
			@Param("descrizione") String descrizione, @Param("data_pubblicazione") Date data_pubblicazione,
			@Param("data_evento") Date data_evento, @Param("id") int id);
}

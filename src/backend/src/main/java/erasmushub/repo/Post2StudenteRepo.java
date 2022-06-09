package erasmushub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Post2Studente;

public interface Post2StudenteRepo extends JpaRepository<Post2Studente, Integer> {
	// JPQL: Cerca tramite id
	@Query("SELECT p FROM Post2Studente p WHERE p.id = ?1")
	Post2Studente findById(int id);

	// JPQL: Elimina tramite id
	@Modifying
	@Query("DELETE FROM Post2Studente p WHERE p.id = ?1")
	int deleteById(int id);

	// JPQL: Aggiorna tramite id
	@Modifying
	@Query("UPDATE Post2Studente p SET mat_studente = :mat_studente, id_post = :id_post WHERE p.id = :id")
	int updatePost2Studente(@Param("mat_studente") String mat_studente, @Param("id_post") int id_post, @Param("id") int id);

}

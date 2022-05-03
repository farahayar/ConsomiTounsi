package tn.esprit.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Chats;

@Repository
public interface ChatsRepository extends JpaRepository<Chats, Long>{
	@Query(value = "SELECT c FROM Chats c WHERE  ( c.sender.userid = :u and c.reciver.userid = :a )  or  (c.sender.userid = :a and c.reciver.userid = :u ) ORDER BY c.date ")
	List<Chats> findMessageWithAdmin(@Param("u") long userid,@Param("a")long adminid);
	

	@Query(value = "SELECT c FROM Chats c WHERE  c.reciver.userid = :a GROUP BY c.sender.userid ORDER BY c.date  ")
	List<Chats> findAdminListChat(@Param("a")long adminid);
}

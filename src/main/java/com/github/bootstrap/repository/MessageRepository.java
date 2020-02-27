package com.github.bootstrap.repository;

import com.github.bootstrap.dto.MessageDTO;
import com.github.bootstrap.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

   /* @Query("Select USER_NAME from TBL_MESSAGES WHERE LENGTH(DESCRIPTION) >= ?1")
    List<MessageDTO> findDtoByDescriptionThanMoreOrEqual(int length);
*/
}

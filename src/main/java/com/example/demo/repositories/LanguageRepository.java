package com.example.demo.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entities.Language;
public interface LanguageRepository extends JpaRepository<Language, Long> {
     // JPQL query to find a language by name
    @Query("SELECT l FROM Language l WHERE l.languageName = :languageName")
    Language findByLanguageName(String languageName);
    @SuppressWarnings("null")
    Optional<Language> findById(Long id);
}

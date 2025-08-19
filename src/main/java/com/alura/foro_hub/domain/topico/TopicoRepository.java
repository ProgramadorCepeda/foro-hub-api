package com.alura.foro_hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Verificar si ya existe un tópico con el mismo título y mensaje
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    // Buscar tópicos por curso
    @Query("SELECT t FROM Topico t WHERE t.curso.nombre = :nombreCurso")
    Page<Topico> findByCursoNombre(@Param("nombreCurso") String nombreCurso, Pageable pageable);

    // Buscar tópicos por año
    @Query("SELECT t FROM Topico t WHERE YEAR(t.fechaCreacion) = :ano")
    Page<Topico> findByAno(@Param("ano") Integer ano, Pageable pageable);
}
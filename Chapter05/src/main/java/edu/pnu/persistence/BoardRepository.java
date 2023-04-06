/**
 * 
 */
package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

/**
 * @author SW
 *
 */
public interface BoardRepository extends CrudRepository<Board, Long> {
	List<Board> findByTitleContaining(String title);
	List<Board> findByTitleContainingAndCntGreaterThan(String title, Long cnt);
	List<Board> findByCntBetweenOrderBySeq(Long first, Long last);
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	@Query("select b from Board b order by b.seq desc")
	List<Board> queryAnnotationTest(Pageable paging);
	
	@Query(value = "select seq, title, writer, create_date "
			+ "from board where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest2(String searchKeyword);
	
	@Query("select b.seq, b.title, b.writer, b.createDate "
			+ "from Board b "
			+ "where b.title like %?1% "
			+ "order by b.seq desc")
	List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
}

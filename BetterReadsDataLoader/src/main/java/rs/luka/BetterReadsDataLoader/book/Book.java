package rs.luka.BetterReadsDataLoader.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "book_by_id")
public class Book {
	
	@Id
	@PrimaryKeyColumn(name = "book_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String id;
	
	@Column("book_name")
	@CassandraType(type = Name.TEXT)
	private String name;
	
	@Column("book_description")
	@CassandraType(type = Name.TEXT)
	private String description;
	
	@Column("publish_date")
	@CassandraType(type = Name.DATE)
	private LocalDate publishDate;
	
	
	@Column("cover_ids")
	@CassandraType(type = Name.LIST, typeArguments = Name.TEXT)
	private List<String> coverIds;

	public String getDecription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public List<String> getCoverIds() {
		return coverIds;
	}

	public void setCoverIds(List<String> coverIds) {
		this.coverIds = coverIds;
	}

	public List<String> getAuthorNames() {
		return authorNames;
	}

	public void setAuthorNames(List<String> authorNames) {
		this.authorNames = authorNames;
	}

	public List<String> getAuthorId() {
		return authorId;
	}

	public void setAuthorId(List<String> authorId) {
		this.authorId = authorId;
	}

	@Column("author_names")
	@CassandraType(type = Name.LIST, typeArguments = Name.TEXT)
	private List<String> authorNames;
	
	@Column("author_id")
	@CassandraType(type = Name.LIST, typeArguments = Name.TEXT)
	private List<String> authorId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}

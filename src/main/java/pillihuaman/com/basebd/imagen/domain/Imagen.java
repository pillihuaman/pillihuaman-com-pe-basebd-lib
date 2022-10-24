package pillihuaman.com.basebd.imagen.domain;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import pillihuaman.com.basebd.help.AuditEntity;

@Component
public class Imagen implements Serializable {
	private static final long serialVersionUID = 1L;
	@BsonProperty(value = "_id")
	private ObjectId id;
	@BsonProperty(value = "description")
	private String description;
	@BsonProperty(value = "name")
	private String name;
	@BsonProperty(value = "id_user")
	private int idUser;
	@BsonProperty(value = "id_head_imagen")
	private int idHeadImagen;
	@BsonProperty(value = "id_System")
	private int idSystem;
	@BsonProperty(value = "id_product")
	private int idProduct;

	private AuditEntity auditEntity;

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdHeadImagen() {
		return idHeadImagen;
	}

	public void setIdHeadImagen(int idHeadImagen) {
		this.idHeadImagen = idHeadImagen;
	}

	public int getIdSystem() {
		return idSystem;
	}

	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}

	public AuditEntity getAuditEntity() {
		return auditEntity;
	}

	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}

	public Imagen() {
	}

}
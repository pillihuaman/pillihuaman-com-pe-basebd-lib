package pillihuaman.com.basebd.product.domain;

import java.io.Serializable;
import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import pillihuaman.com.basebd.help.AuditEntity;

@Component
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@BsonProperty(value = "_id")
	private ObjectId id;
	@BsonProperty(value = "description")
	private String description;
	@BsonProperty(value = "name")
	private String name;
	@BsonProperty(value = "id_user")
	private int idUser;
	@BsonProperty(value = "id_price")
	private int idPrice;
	@BsonProperty(value = "id_imagen")
	private int idImagen;
	@BsonProperty(value = "idSystem")
	private int idSystem;
	@BsonProperty(value = "id_stock")
	private int idStock;
	@BsonProperty(value = "id_position")
	private int idPosition;
	@BsonProperty(value = "id_product")
	private int idProduct;
	@BsonProperty(value = "expiration_date")
	private Date expirationDate;
	@BsonProperty(value = "idType")
	private int idType;

	private AuditEntity auditEntity;

	public Product() {
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
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

	public int getIdPrice() {
		return idPrice;
	}

	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public int getIdSystem() {
		return idSystem;
	}

	public void setIdSystem(int idSystem) {
		this.idSystem = idSystem;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public AuditEntity docAud() {
		return auditEntity;
	}

	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}

}
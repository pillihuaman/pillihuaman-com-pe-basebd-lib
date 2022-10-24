package pillihuaman.com.basebd.imagen.domain;

import java.io.Serializable;
import java.math.BigInteger;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import pillihuaman.com.basebd.help.AuditEntity;

@Component
public class DetailImage implements Serializable {
	private static final long serialVersionUID = 1L;
	@BsonProperty(value = "_id")
	private ObjectId id;
	@BsonProperty(value = "id_head_imagen")
	private int idHeadImagen;
	@BsonProperty(value = "id_imagen")
	private int idImagen;
	@BsonProperty(value = "name")
	private String name;
	@BsonProperty(value = "count_ranking")
	private BigInteger countRanking;
	@BsonProperty(value = "click_count")
	private BigInteger clickCount;

	@BsonProperty(value = "idType")
	private int idType;

	@BsonProperty(value = "files")
	private byte[] files;

	@BsonProperty(value = "id_detail")
	private ObjectId idDetail;
	

	@BsonProperty(value = "_object_id")
	private ObjectId _objectId;
	
	private AuditEntity auditEntity;

	public ObjectId get_objectId() {
		return _objectId;
	}

	public void set_objectId(ObjectId _objectId) {
		this._objectId = _objectId;
	}

	public ObjectId getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(ObjectId idDetail) {
		this.idDetail = idDetail;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getIdHeadImagen() {
		return idHeadImagen;
	}

	public void setIdHeadImagen(int idHeadImagen) {
		this.idHeadImagen = idHeadImagen;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getCountRanking() {
		return countRanking;
	}

	public void setCountRanking(BigInteger countRanking) {
		this.countRanking = countRanking;
	}

	public BigInteger getClickCount() {
		return clickCount;
	}

	public void setClickCount(BigInteger clickCount) {
		this.clickCount = clickCount;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
	}

	public AuditEntity getAuditEntity() {
		return auditEntity;
	}

	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}

	public DetailImage() {
	}

}
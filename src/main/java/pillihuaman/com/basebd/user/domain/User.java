package pillihuaman.com.basebd.user.domain;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import pillihuaman.com.basebd.help.AuditEntity;

@Component
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@BsonProperty(value = "_id")
	private ObjectId id;

	private AuditEntity AuditEntity;
	private String alias;
	private String api_password;
	private int id_system;
	private String mail;
	private String mobil_phone;
	private String password;
	private String sal_password;
	private String user_name;
	private String type_document;
	private String numType_document;
	private ObjectId id_user;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	public AuditEntity getAuditEntity() {
		return AuditEntity;
	}
	public void setAuditEntity(AuditEntity auditEntity) {
		AuditEntity = auditEntity;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getApi_password() {
		return api_password;
	}
	public void setApi_password(String api_password) {
		this.api_password = api_password;
	}
	public int getId_system() {
		return id_system;
	}
	public void setId_system(int id_system) {
		this.id_system = id_system;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobil_phone() {
		return mobil_phone;
	}
	public void setMobil_phone(String mobil_phone) {
		this.mobil_phone = mobil_phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSal_password() {
		return sal_password;
	}
	public void setSal_password(String sal_password) {
		this.sal_password = sal_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getType_document() {
		return type_document;
	}
	public void setType_document(String type_document) {
		this.type_document = type_document;
	}
	public String getNumType_document() {
		return numType_document;
	}
	public void setNumType_document(String numType_document) {
		this.numType_document = numType_document;
	}
	public ObjectId getId_user() {
		return id_user;
	}
	public void setId_user(ObjectId id_user) {
		this.id_user = id_user;
	}

}
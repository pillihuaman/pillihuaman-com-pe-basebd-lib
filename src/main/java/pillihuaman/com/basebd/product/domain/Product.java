package pillihuaman.com.basebd.product.domain;

import java.io.Serializable;
import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import pillihuaman.com.basebd.common.ProductStock;
import pillihuaman.com.basebd.help.AuditEntity;

@Component
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @BsonId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    private String description;
    private String name;
    private int idUser;
    private float idPrice;
    private int idImagen;
    private int idSystem;
    private ProductStock idStock;
    private int idPosition;
    private ObjectId idProduct;
    private Date expirationDate;
    private int idType;

    private float highPrice;
    private float lowPrice;
    private String currency;

    public float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private AuditEntity auditEntity;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public float getIdPrice() {
        return idPrice;
    }

    public void setIdPrice(float idPrice) {
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


    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public ProductStock getIdStock() {
        return idStock;
    }

    public void setIdStock(ProductStock idStock) {
        this.idStock = idStock;
    }

    public ObjectId getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ObjectId idProduct) {
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

    public AuditEntity getAuditEntity() {
        return auditEntity;
    }

    public void setAuditEntity(AuditEntity auditEntity) {
        this.auditEntity = auditEntity;
    }


}
package pillihuaman.com.basebd.product.domain.dao.implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoCollection;

import pillihuaman.com.base.commons.Utils;
import pillihuaman.com.base.request.ImagenDetail;
import pillihuaman.com.basebd.common.ProductStock;
import pillihuaman.com.basebd.config.AbstractMongoDBRepositoryImpl;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.product.domain.Color;
import pillihuaman.com.basebd.product.domain.Product;
import pillihuaman.com.basebd.product.domain.Size;
import pillihuaman.com.basebd.product.domain.dao.ProductSupportDAO;

@Component
public class ProductSupportDaoImplement extends AbstractMongoDBRepositoryImpl<Product> implements ProductSupportDAO {
    ProductSupportDaoImplement() {
        DS_WRITE = Constants.DW;
        // DS_READ = Constants.DR;
        COLLECTION = Constants.COLLECTION_PRODUCT;

    }

    @Override
    public boolean SaveProduct(Product request) {
        Document doc = new Document();
        Document docAud = new Document();
        AuditEntity aud = new AuditEntity();
        aud.setCodUsuRegis("ZPH");
        aud.setFecRegis(new Date());
        request.setAuditEntity(aud);
        doc.put("description", request.getDescription());
        doc.put("name", request.getName());
        doc.put("idUser", request.getIdUser());
        docAud.put("codUsuRegis", aud.getCodUsuRegis());
        docAud.put("fecRegis", aud.getFecRegis());

        doc.put("auditEntity", docAud);
        save(doc);
        return true;
    }

    @Override
    public List<Product> getCorrelativeProduct(Product request) {

        MongoCollection<Product> collection = getCollection(this.collectionName, Product.class);
        Document query = new Document();
        Document sort = new Document().append("id_product", -1);
        List<Product> lisProduct = collection.find(query, Product.class).sort(sort).limit(1)
                .into(new ArrayList<Product>());
        return lisProduct;
    }

    @Override
    public Class<Product> provideEntityClass() {
        // TODO Auto-generated method stub
        return Product.class;
    }

    @Override
    public List<Product> getallProductbyUser(Product request) {
        MongoCollection<Product> collection = getCollection(this.collectionName, Product.class);
        Document query = new Document().append("idUser", request.getIdUser());
        List<Product> lisProduct = collection.find(query, Product.class)
                .into(new ArrayList<Product>());
        return lisProduct;
    }

    @Override
    public boolean saveStock(ProductStock request) throws IOException {
        Document doc = new Document();
        Document docAud = new Document();
        AuditEntity aud = new AuditEntity();

        aud.setCodUsuRegis("ZPH");
        aud.setFecRegis(new Date());
        doc.put("idProduct", request.getIdProduct());
        doc.put("expirationDate", request.getExpirationDate());
        doc.put("creationDate", request.getCreationDate());
        doc.put("stock.idProduct", request.getIdProduct());
        doc.put("stock.size", request.getStock().getSize());
        if (Objects.nonNull(request.getStock())) {
            if (Objects.nonNull(request.getStock().getSize())) {
                if (Objects.nonNull(request.getStock().getSize())) {
                    for (Size si :
                            request.getStock().getSize()) {

                        if (Objects.nonNull(si.getColor())) {
                            for (Color co :
                                    si.getColor()) {
                                if (Objects.nonNull(co)) {

                                    for (ImagenDetail deta :
                                            co.getListImagen()) {
                                        Utils.convertBase64ImagenToByteArray(deta.getValue());


                                    }
                                }

                            }

                        }
                    }


                }

            }

        }


        docAud.put("codUsuRegis", aud.getCodUsuRegis());
        docAud.put("fecRegis", aud.getFecRegis());
        request.setAuditEntity(aud);
        doc.put("auditEntity", docAud);
        save(doc);
        return true;
    }
}

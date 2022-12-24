package pillihuaman.com.basebd.help;


import pillihuaman.com.base.request.ReqProduct;
import pillihuaman.com.base.request.ReqUser;
import pillihuaman.com.base.response.CorouselImage;
import pillihuaman.com.base.response.RespImagenGeneral;
import pillihuaman.com.base.response.RespProduct;
import pillihuaman.com.base.response.RespUser;
import pillihuaman.com.basebd.imagenProducer.domain.ImagenFile;
import pillihuaman.com.basebd.product.domain.Product;
import pillihuaman.com.basebd.user.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ConvertClass {


    public static RespUser UserTblToUserDTO(User request) {
        RespUser resp = new RespUser();
        resp.setMail(request.getMail());
        resp.setUsername(request.getUser_name());
        resp.setAlias(request.getAlias());
        resp.setApi_Password(request.getApi_password());
        resp.setSal_Password(request.getSal_password());
        resp.setPassword(request.getPassword());
        return resp;

    }

    public static Product ProductDtoToProductTbl(ReqProduct request) {
        Product resp = new Product();
        resp.setDescription(request.getDescription());
        resp.setExpirationDate(request.getExpirationDate());
        resp.setIdImagen(request.getIdImagen());
        resp.setIdPrice(request.getIdPrice());
        resp.setIdProduct(request.getIdProduct());
        resp.setIdSystem(request.getIdSystem());
        resp.setIdType(request.getIdType());
        resp.setIdUser(request.getIdUser());
        resp.setName(request.getName());
        return resp;

    }

    public static List<RespProduct> listProductoRespProduct(List<Product> lstproduct) {
        List<RespProduct> lstresp = new ArrayList<>();
        if (lstproduct != null && !lstproduct.isEmpty()) {
            for (Product product : lstproduct
            ) {
                RespProduct resp = new RespProduct();
                resp.setDescription(product.getDescription());
                resp.setExpirationDate(product.getExpirationDate());
                resp.setIdImagen(product.getIdImagen());
                resp.setIdPrice(product.getIdPrice());
                resp.setIdProduct(product.getIdProduct());
                resp.setIdSystem(product.getIdSystem());
                resp.setIdType(product.getIdType());
                resp.setIdUser(product.getIdUser());
                resp.setName(product.getName());
                lstresp.add(resp);

            }

        }
        return lstresp;

    }

    public static User userDtoToUserTbl(ReqUser request) {
        User resp = new User();

        resp.setAlias(request.getAlias());
        resp.setId_system(request.getId_System());
        resp.setMail(request.getMail());
        resp.setMobil_phone(request.getMobilPhone());
        resp.setPassword(request.getPassword());
        resp.setUser_name(request.getUsername());

        return resp;

    }

    public static RespUser respUserDtoToUser(User request) {
        RespUser resp = new RespUser();

        resp.setAlias(request.getAlias());
        resp.setId_system(request.getId_system());
        resp.setMail(request.getMail());
        resp.setMobil_Phone(request.getMobil_phone());
        resp.setUsername(request.getUser_name());
        resp.setPassword(request.getPassword());


        return resp;

    }

    public static List<CorouselImage> respListImagenFileToImagenGeneral(List<ImagenFile> request) {
        List<CorouselImage> lst = new ArrayList<>();
        int count = 0;
        int clickCountMax = 0;
        int max = 0;
        for (ImagenFile im :
                request) {
            CorouselImage imr = new CorouselImage();
            clickCountMax = im.getMetadata().getClickCount();
            if (clickCountMax > max) {
                max = clickCountMax;
            }


            imr.setImageSrc(im.getId().toString());
            imr.setImageAlt(im.getFilename());
            imr.setImageCountainerToken(UUID.randomUUID().toString());
            imr.setImagetoken(UUID.randomUUID().toString());
            imr.setIndex(im.getMetadata().getIndex());
            imr.setIdDetail(im.getMetadata().getIdDetail().toString());
            count++;
            if (count == request.size()) {

                imr.setIndicators(true);
                imr.setFirstObject(max + "");
            }else{
                imr.setFirstObject(null);
                imr.setIndicators(false);
            }
            lst.add(imr);
        }
        return lst;

    }


}

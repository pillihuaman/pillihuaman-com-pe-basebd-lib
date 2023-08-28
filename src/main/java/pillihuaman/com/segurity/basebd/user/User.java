package pillihuaman.com.segurity.basebd.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pillihuaman.com.segurity.basebd.token.Token;
import pillihuaman.com.segurity.basebd.help.AuditEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Component
@Builder
@AllArgsConstructor
@Document(collection = "user")
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

   @Id
    private ObjectId id;

    private AuditEntity auditEntity;
    private String alias;
    private String api_password;
    private int id_system;
    private String email;
    private String mobil_phone;
    private String password;
    private String sal_password;
    private String name;
    private String type_document;
    private String numType_document;
    private ObjectId id_user;
    private Role role;
    private List<Token> tokens;


    public User() {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public AuditEntity getAuditEntity() {
        return auditEntity;
    }

    public void setAuditEntity(AuditEntity auditEntity) {
        this.auditEntity = auditEntity;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobil_phone() {
        return mobil_phone;
    }

    public void setMobil_phone(String mobil_phone) {
        this.mobil_phone = mobil_phone;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
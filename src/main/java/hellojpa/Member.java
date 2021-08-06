package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id //PK 매핑
    private Long id;

    @Column(name = "name") //DB는 name
    private String username; //객체는 username

    private Integer age;

    @Enumerated(EnumType.STRING) //Enum타입
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //날짜시간
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lasModifiedDate;


    // hibernate가 애노테이션 없어도 타입으로 구별해준다.
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob //varchar를 넘어서는 큰 콘텐츠 넣을 때
    private String description;

    @Transient //DB랑 관계없이 메모리에서 사용용
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLasModifiedDate() {
        return lasModifiedDate;
    }

    public void setLasModifiedDate(Date lasModifiedDate) {
        this.lasModifiedDate = lasModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}

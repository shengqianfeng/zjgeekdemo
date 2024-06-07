package demo.unjuanable.domain.orgmng.org;

import demo.unjuanable.common.framework.domain.AuditableEntity;

import java.time.LocalDateTime;

/**
 * 要提高封装性，可以从两个角度考虑。
 * 第一是限制 getter 和 setter 的数量；
 * 第二是用表示业务含义的接口代替简单的 setter 和 getter。
 * 由于 getter 只是用来查询，不会破坏数据，而不恰当的 setter 则可能破坏数据，导致程序出错，
 * 所以相对而言，限制 setter 比限制 getter 更重要一些。
 * 我们可以只为那些可以修改的属性保留 setter，其他的只有 getter，成为只读属性。
 * 再为 Org 类增加一个包含只读属性的构造器，以便创建对象。
 */
public class Org extends AuditableEntity {
    private final Long tenantId;
    private Long id;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private OrgStatus status;

    public Org(Long tenantId, String orgTypeCode, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.tenantId = tenantId;
        this.orgTypeCode = orgTypeCode;
        status = OrgStatus.EFFECTIVE;
    }

    public Long getId() {
        return id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public String getName() {
        return name;
    }

    public OrgStatus getStatus() {
        return status;
    }

    public boolean isEffective() {
        return status.equals(OrgStatus.EFFECTIVE);
    }

    public boolean isCanceled() {
        return status.equals(OrgStatus.CANCELLED);
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(OrgStatus status) {
        this.status = status;
    }

    public void cancel() {
        this.status = OrgStatus.CANCELLED;
    }

    /***
     * OrgReBuilder跟Org对象在同一个package，所以可以回填这个Id
     * @param id
     */
    void setId(Long id) {
        this.id = id;
    }
}

package demo.unjuanable.application.orgmng.orgservice;

/***
 * CreateOrgRequest: 解决的问题是，简单粗暴地把所有属性都暴露给客户端，不仅违反了最小接口原则，也容易在理解上发生混淆
 */
public class CreateOrgRequest {
    private Long tenant;
    private Long superior;
    private String orgType;
    private Long leader;
    private String name;

    public Long getTenantId() {
        return tenant;
    }

    public void setTenant(Long tenant) {
        this.tenant = tenant;
    }

    public Long getSuperiorId() {
        return superior;
    }

    public void setSuperior(Long superior) {
        this.superior = superior;
    }

    public String getOrgTypeCode() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public Long getLeaderId() {
        return leader;
    }

    public void setLeader(Long leader) {
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrgDto{ tenant=" + tenant +
                ", superior=" + superior +
                ", orgType='" + orgType + '\'' +
                ", leader=" + leader +
                ", name='" + name + '\'' +
                '}';
    }
}

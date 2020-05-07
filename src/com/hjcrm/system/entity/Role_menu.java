package com.hjcrm.system.entity;

public class Role_menu {

    private int id;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    private int roleid;//` bigint(20) DEFAULT NULL COMMENT '角色id',
    private int menuid;//` bigint(20) DEFAULT NULL COMMENT '菜单id',
    private int dr;//` int(1) DEFAULT '0' COMMENT '删除标志 0未删除 1已删除',

    public Role_menu() {
    }

    public Role_menu(int id, int roleid, int menuid, int dr) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
        this.dr = dr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    @Override
    public String toString() {
        return "Role_menu{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", menuid=" + menuid +
                ", dr=" + dr +
                '}';
    }

}

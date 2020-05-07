package com.hjcrm.system.entity;


import java.sql.Timestamp;

public class Student {
    private int studentId;// 学员表主键id
    private int resourceId;// 资源id
    private int userid;// 用户id
    private int belongid;//学员归属人ID
    private int customerId;//客服人员ID
    private Timestamp customer_time;//分配客服时间
    private String studentName;//学员姓名
    private String phone;//学员手机号
    private String tel;//座机
    private String weixin;//微信号
    private String qq;//QQ号
    private String address;//地区
    private int sex;//性别 0男 1女
    private int source;//渠道: 0自建  1课程注册  2在线注册  3app下载注册   4电话咨询   5金考网注册用户   6线上渠道  7在线咨询  8大库资源 9 在线购买
    private String resourceLevel;//资源等级     A B C D
    private String idCard;// 身份证号码
    private String nation;// 民族
    private String education;// 学历
    private String school;// 毕业院校
    private String email;// 邮箱
    private String company;// 工作单位
    private String department;// 工作部门
    private String position;// 职务
    private String companyAddr;// 公司地址
    private String homeAddr;// 家庭住址
    private String companyTel;// 公司电话
    private int isjieye;// 是否协助结业 0：否 1：是
    private String LCWname; // 理财网用户名
    private String LCWpassword;// 理财网密码
    private Timestamp LCWoutTime;// 理财网过期时间
    private String banci;//班级
    private String classNum;// 上课班号
    private String qici;// 期次
    private int isSignAgreement;// 是否签订协议 0未签订 1已签订
    private String courseversion;// 课件版本
    private Timestamp mailTime;// 邮寄时间
    private String mailTim;
    private int isHaveCourse;// 是否上过课 0未上过课 1已上过课
    private String kefuNote1;// 客服备注1
    private String kefuNote2;// 客服备注2
    private String baokaopassword;// 报考密码
    private int dr;// 删除标志 0未删除 1已删除
    private int studentstate;//学员状态 0新增 1已成交 2已提交 3已到账 4已分配 5已转入 6已通过考试 7已关课 8已退回
    private String returnNote;//退回原因
    private Timestamp returnTime;//退回时间
    private int returnId;//退回人
    private Timestamp create_time;//创建时间
    private Timestamp update_time;//修改时间
    private int update_id;//修改人
    private Timestamp commit_time;//提交行政日期
    private String headmaster;//班主任
    private int courseid;//课程ID
    private Timestamp matchinfo_time;//确认到账时间
    private String arrive_time;//收款时间
    private String arrive_money;//收款金额
    private String remitWay;//汇款方式
    private int ishavenetedu;//是否存在网络培训费 0无 1有
    private int isOnlineBuy;//是否在线购买 0否 1是
    private String netedumoney;//网络培训费金额
    private String invoiceinfo;//发票情况
    private String preferinfo;//优惠信息
    private String remituser;//代汇款人
    private int ispass;// 是否通过 0未通过 1通过 2缺考
    private Timestamp passtime;// 通过时间
    private Timestamp dealtime;// 成交时间
    private String dealprice;// 成交金额
    private int iscommitcaiwu;//行政是否提交财务 0未提交 1已提交
    private Timestamp commitTime_caiwu;//行政提交财务时间
    private String paytime;//支付日期
    private String xingzhengNote;//行政备注
    private Timestamp scoretime;//考试日期
    private String scoretim;
    private String studentEvaluate;//学员评价     优 良 中 差
    private String tuifei;//退费
    private String tuifeitime;//退费时间
    private String shenhe;//审核情况
    private String caiwunote;//财务备注
    private String specialinfo;//特殊情况
    private String studentColor;//学员颜色标记
    private int isolddata;//是否历史数据 0 否 1是

    private String courseName;
    private String subjectname;
    private String createrName;
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private int pageSize;
    private int currentPage;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Student() {
        super();
    }

    public Student(int studentId, int resourceId, int userid, int belongid, int customerId, Timestamp customer_time, String studentName, String phone, String tel, String weixin, String qq, String address, int sex, int source, String resourceLevel, String idCard, String nation, String education, String school, String email, String company, String department, String position, String companyAddr, String homeAddr, String companyTel, int isjieye, String LCWname, String LCWpassword, Timestamp LCWoutTime, String banci, String classNum, String qici, int isSignAgreement, String courseversion, Timestamp mailTime, String mailTim, int isHaveCourse, String kefuNote1, String kefuNote2, String baokaopassword, int dr, int studentstate, String returnNote, Timestamp returnTime, int returnId, Timestamp create_time, Timestamp update_time, int update_id, Timestamp commit_time, String headmaster, int courseid, Timestamp matchinfo_time, String arrive_time, String arrive_money, String remitWay, int ishavenetedu, int isOnlineBuy, String netedumoney, String invoiceinfo, String preferinfo, String remituser, int ispass, Timestamp passtime, Timestamp dealtime, String dealprice, int iscommitcaiwu, Timestamp commitTime_caiwu, String paytime, String xingzhengNote, Timestamp scoretime, String scoretim, String studentEvaluate, String tuifei, String tuifeitime, String shenhe, String caiwunote, String specialinfo, String studentColor, int isolddata) {
        this.studentId = studentId;
        this.resourceId = resourceId;
        this.userid = userid;
        this.belongid = belongid;
        this.customerId = customerId;
        this.customer_time = customer_time;
        this.studentName = studentName;
        this.phone = phone;
        this.tel = tel;
        this.weixin = weixin;
        this.qq = qq;
        this.address = address;
        this.sex = sex;
        this.source = source;
        this.resourceLevel = resourceLevel;
        this.idCard = idCard;
        this.nation = nation;
        this.education = education;
        this.school = school;
        this.email = email;
        this.company = company;
        this.department = department;
        this.position = position;
        this.companyAddr = companyAddr;
        this.homeAddr = homeAddr;
        this.companyTel = companyTel;
        this.isjieye = isjieye;
        this.LCWname = LCWname;
        this.LCWpassword = LCWpassword;
        this.LCWoutTime = LCWoutTime;
        this.banci = banci;
        this.classNum = classNum;
        this.qici = qici;
        this.isSignAgreement = isSignAgreement;
        this.courseversion = courseversion;
        this.mailTime = mailTime;
        this.mailTim = mailTim;
        this.isHaveCourse = isHaveCourse;
        this.kefuNote1 = kefuNote1;
        this.kefuNote2 = kefuNote2;
        this.baokaopassword = baokaopassword;
        this.dr = dr;
        this.studentstate = studentstate;
        this.returnNote = returnNote;
        this.returnTime = returnTime;
        this.returnId = returnId;
        this.create_time = create_time;
        this.update_time = update_time;
        this.update_id = update_id;
        this.commit_time = commit_time;
        this.headmaster = headmaster;
        this.courseid = courseid;
        this.matchinfo_time = matchinfo_time;
        this.arrive_time = arrive_time;
        this.arrive_money = arrive_money;
        this.remitWay = remitWay;
        this.ishavenetedu = ishavenetedu;
        this.isOnlineBuy = isOnlineBuy;
        this.netedumoney = netedumoney;
        this.invoiceinfo = invoiceinfo;
        this.preferinfo = preferinfo;
        this.remituser = remituser;
        this.ispass = ispass;
        this.passtime = passtime;
        this.dealtime = dealtime;
        this.dealprice = dealprice;
        this.iscommitcaiwu = iscommitcaiwu;
        this.commitTime_caiwu = commitTime_caiwu;
        this.paytime = paytime;
        this.xingzhengNote = xingzhengNote;
        this.scoretime = scoretime;
        this.scoretim = scoretim;
        this.studentEvaluate = studentEvaluate;
        this.tuifei = tuifei;
        this.tuifeitime = tuifeitime;
        this.shenhe = shenhe;
        this.caiwunote = caiwunote;
        this.specialinfo = specialinfo;
        this.studentColor = studentColor;
        this.isolddata = isolddata;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBelongid() {
        return belongid;
    }

    public void setBelongid(int belongid) {
        this.belongid = belongid;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getCustomer_time() {
        return customer_time;
    }

    public void setCustomer_time(Timestamp customer_time) {
        this.customer_time = customer_time;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public int getIsjieye() {
        return isjieye;
    }

    public void setIsjieye(int isjieye) {
        this.isjieye = isjieye;
    }

    public String getLCWname() {
        return LCWname;
    }

    public void setLCWname(String LCWname) {
        this.LCWname = LCWname;
    }

    public String getLCWpassword() {
        return LCWpassword;
    }

    public void setLCWpassword(String LCWpassword) {
        this.LCWpassword = LCWpassword;
    }

    public Timestamp getLCWoutTime() {
        return LCWoutTime;
    }

    public void setLCWoutTime(Timestamp LCWoutTime) {
        this.LCWoutTime = LCWoutTime;
    }

    public String getBanci() {
        return banci;
    }

    public void setBanci(String banci) {
        this.banci = banci;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getQici() {
        return qici;
    }

    public void setQici(String qici) {
        this.qici = qici;
    }

    public int getIsSignAgreement() {
        return isSignAgreement;
    }

    public void setIsSignAgreement(int isSignAgreement) {
        this.isSignAgreement = isSignAgreement;
    }

    public String getCourseversion() {
        return courseversion;
    }

    public void setCourseversion(String courseversion) {
        this.courseversion = courseversion;
    }

    public Timestamp getMailTime() {
        return mailTime;
    }

    public void setMailTime(Timestamp mailTime) {
        this.mailTime = mailTime;
    }

    public String getMailTim() {
        return mailTim;
    }

    public void setMailTim(String mailTim) {
        this.mailTim = mailTim;
    }

    public int getIsHaveCourse() {
        return isHaveCourse;
    }

    public void setIsHaveCourse(int isHaveCourse) {
        this.isHaveCourse = isHaveCourse;
    }

    public String getKefuNote1() {
        return kefuNote1;
    }

    public void setKefuNote1(String kefuNote1) {
        this.kefuNote1 = kefuNote1;
    }

    public String getKefuNote2() {
        return kefuNote2;
    }

    public void setKefuNote2(String kefuNote2) {
        this.kefuNote2 = kefuNote2;
    }

    public String getBaokaopassword() {
        return baokaopassword;
    }

    public void setBaokaopassword(String baokaopassword) {
        this.baokaopassword = baokaopassword;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getStudentstate() {
        return studentstate;
    }

    public void setStudentstate(int studentstate) {
        this.studentstate = studentstate;
    }

    public String getReturnNote() {
        return returnNote;
    }

    public void setReturnNote(String returnNote) {
        this.returnNote = returnNote;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Timestamp getCommit_time() {
        return commit_time;
    }

    public void setCommit_time(Timestamp commit_time) {
        this.commit_time = commit_time;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public Timestamp getMatchinfo_time() {
        return matchinfo_time;
    }

    public void setMatchinfo_time(Timestamp matchinfo_time) {
        this.matchinfo_time = matchinfo_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getArrive_money() {
        return arrive_money;
    }

    public void setArrive_money(String arrive_money) {
        this.arrive_money = arrive_money;
    }

    public String getRemitWay() {
        return remitWay;
    }

    public void setRemitWay(String remitWay) {
        this.remitWay = remitWay;
    }

    public int getIshavenetedu() {
        return ishavenetedu;
    }

    public void setIshavenetedu(int ishavenetedu) {
        this.ishavenetedu = ishavenetedu;
    }

    public int getIsOnlineBuy() {
        return isOnlineBuy;
    }

    public void setIsOnlineBuy(int isOnlineBuy) {
        this.isOnlineBuy = isOnlineBuy;
    }

    public String getNetedumoney() {
        return netedumoney;
    }

    public void setNetedumoney(String netedumoney) {
        this.netedumoney = netedumoney;
    }

    public String getInvoiceinfo() {
        return invoiceinfo;
    }

    public void setInvoiceinfo(String invoiceinfo) {
        this.invoiceinfo = invoiceinfo;
    }

    public String getPreferinfo() {
        return preferinfo;
    }

    public void setPreferinfo(String preferinfo) {
        this.preferinfo = preferinfo;
    }

    public String getRemituser() {
        return remituser;
    }

    public void setRemituser(String remituser) {
        this.remituser = remituser;
    }

    public int getIspass() {
        return ispass;
    }

    public void setIspass(int ispass) {
        this.ispass = ispass;
    }

    public Timestamp getPasstime() {
        return passtime;
    }

    public void setPasstime(Timestamp passtime) {
        this.passtime = passtime;
    }

    public Timestamp getDealtime() {
        return dealtime;
    }

    public void setDealtime(Timestamp dealtime) {
        this.dealtime = dealtime;
    }

    public String getDealprice() {
        return dealprice;
    }

    public void setDealprice(String dealprice) {
        this.dealprice = dealprice;
    }

    public int getIscommitcaiwu() {
        return iscommitcaiwu;
    }

    public void setIscommitcaiwu(int iscommitcaiwu) {
        this.iscommitcaiwu = iscommitcaiwu;
    }

    public Timestamp getCommitTime_caiwu() {
        return commitTime_caiwu;
    }

    public void setCommitTime_caiwu(Timestamp commitTime_caiwu) {
        this.commitTime_caiwu = commitTime_caiwu;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getXingzhengNote() {
        return xingzhengNote;
    }

    public void setXingzhengNote(String xingzhengNote) {
        this.xingzhengNote = xingzhengNote;
    }

    public Timestamp getScoretime() {
        return scoretime;
    }

    public void setScoretime(Timestamp scoretime) {
        this.scoretime = scoretime;
    }

    public String getScoretim() {
        return scoretim;
    }

    public void setScoretim(String scoretim) {
        this.scoretim = scoretim;
    }

    public String getStudentEvaluate() {
        return studentEvaluate;
    }

    public void setStudentEvaluate(String studentEvaluate) {
        this.studentEvaluate = studentEvaluate;
    }

    public String getTuifei() {
        return tuifei;
    }

    public void setTuifei(String tuifei) {
        this.tuifei = tuifei;
    }

    public String getTuifeitime() {
        return tuifeitime;
    }

    public void setTuifeitime(String tuifeitime) {
        this.tuifeitime = tuifeitime;
    }

    public String getShenhe() {
        return shenhe;
    }

    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

    public String getCaiwunote() {
        return caiwunote;
    }

    public void setCaiwunote(String caiwunote) {
        this.caiwunote = caiwunote;
    }

    public String getSpecialinfo() {
        return specialinfo;
    }

    public void setSpecialinfo(String specialinfo) {
        this.specialinfo = specialinfo;
    }

    public String getStudentColor() {
        return studentColor;
    }

    public void setStudentColor(String studentColor) {
        this.studentColor = studentColor;
    }

    public int getIsolddata() {
        return isolddata;
    }

    public void setIsolddata(int isolddata) {
        this.isolddata = isolddata;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", resourceId=" + resourceId +
                ", userid=" + userid +
                ", belongid=" + belongid +
                ", customerId=" + customerId +
                ", customer_time=" + customer_time +
                ", studentName='" + studentName + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", source=" + source +
                ", resourceLevel='" + resourceLevel + '\'' +
                ", idCard='" + idCard + '\'' +
                ", nation='" + nation + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", companyAddr='" + companyAddr + '\'' +
                ", homeAddr='" + homeAddr + '\'' +
                ", companyTel='" + companyTel + '\'' +
                ", isjieye=" + isjieye +
                ", LCWname='" + LCWname + '\'' +
                ", LCWpassword='" + LCWpassword + '\'' +
                ", LCWoutTime=" + LCWoutTime +
                ", banci='" + banci + '\'' +
                ", classNum='" + classNum + '\'' +
                ", qici='" + qici + '\'' +
                ", isSignAgreement=" + isSignAgreement +
                ", courseversion='" + courseversion + '\'' +
                ", mailTime=" + mailTime +
                ", mailTim='" + mailTim + '\'' +
                ", isHaveCourse=" + isHaveCourse +
                ", kefuNote1='" + kefuNote1 + '\'' +
                ", kefuNote2='" + kefuNote2 + '\'' +
                ", baokaopassword='" + baokaopassword + '\'' +
                ", dr=" + dr +
                ", studentstate=" + studentstate +
                ", returnNote='" + returnNote + '\'' +
                ", returnTime=" + returnTime +
                ", returnId=" + returnId +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", commit_time=" + commit_time +
                ", headmaster='" + headmaster + '\'' +
                ", courseid=" + courseid +
                ", matchinfo_time=" + matchinfo_time +
                ", arrive_time='" + arrive_time + '\'' +
                ", arrive_money='" + arrive_money + '\'' +
                ", remitWay='" + remitWay + '\'' +
                ", ishavenetedu=" + ishavenetedu +
                ", isOnlineBuy=" + isOnlineBuy +
                ", netedumoney='" + netedumoney + '\'' +
                ", invoiceinfo='" + invoiceinfo + '\'' +
                ", preferinfo='" + preferinfo + '\'' +
                ", remituser='" + remituser + '\'' +
                ", ispass=" + ispass +
                ", passtime=" + passtime +
                ", dealtime=" + dealtime +
                ", dealprice='" + dealprice + '\'' +
                ", iscommitcaiwu=" + iscommitcaiwu +
                ", commitTime_caiwu=" + commitTime_caiwu +
                ", paytime='" + paytime + '\'' +
                ", xingzhengNote='" + xingzhengNote + '\'' +
                ", scoretime=" + scoretime +
                ", scoretim='" + scoretim + '\'' +
                ", studentEvaluate='" + studentEvaluate + '\'' +
                ", tuifei='" + tuifei + '\'' +
                ", tuifeitime='" + tuifeitime + '\'' +
                ", shenhe='" + shenhe + '\'' +
                ", caiwunote='" + caiwunote + '\'' +
                ", specialinfo='" + specialinfo + '\'' +
                ", studentColor='" + studentColor + '\'' +
                ", isolddata=" + isolddata +
                '}';
    }
}

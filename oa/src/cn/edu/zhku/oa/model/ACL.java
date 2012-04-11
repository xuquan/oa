package cn.edu.zhku.oa.model;

/**
 * ���ߣ���Ȩ
 * @hibernate.class table="t_acl"
 */
public class ACL {
	
	/**
	 * �������ͣ���ɫ
	 */
	public static final String TYPE_ROLE = "Role";
	
	/**
	 * �������ͣ��û�
	 */
	public static final String TYPE_USER = "User";
	
	/**
	 * ��Ȩ����
	 */
	public static final int ACL_YES = 1;
	
	/**
	 * ��Ȩ������
	 */
	public static final int ACL_NO = 0;
	
	/**
	 * ��Ȩ��ȷ��
	 */
	public static final int ACL_NEUTRAL = 0;
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * �������ͣ���ɫ���û�
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private String principalType;
	
	/**
	 * �����ʶ����ɫ���û���ʶ
	 *  @hibernate.property
	 * 		not-null="true"
	 */
	private int principalSn;
	
	/**
	 * ��Դ��ʶ
	 *  @hibernate.property
	 * 		not-null="true"
	 */
	private int resourceSn;
	
	/**
	 * ��Ȩ״̬���������λ��bit������ʾCRUD����
	 *  @hibernate.property
	 * 		not-null="true"
	 */
	private int aclState;
	
	/**
	 * ��ʾ�Ƿ�̳У�0��ʾ���̳У�-1��ʾ�̳�
	 *  @hibernate.property
	 * 		not-null="true"
	 */
	private int aclTriState;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getPrincipalSn() {
		return principalSn;
	}

	public void setPrincipalSn(int principalSn) {
		this.principalSn = principalSn;
	}

	public int getResourceSn() {
		return resourceSn;
	}

	public void setResourceSn(int resourceSn) {
		this.resourceSn = resourceSn;
	}

	public int getAclState() {
		return aclState;
	}

	public void setAclState(int aclState) {
		this.aclState = aclState;
	}

	public int getAclTriState() {
		return aclTriState;
	}

	public void setAclTriState(int aclTriState) {
		this.aclTriState = aclTriState;
	}
	
	/**
	 * aclʵ�����������Դ����
	 * ��Դ�ʵ��������Ȩ��ĳ�ֲ����Ƿ�����
	 * @param permission ֻ����ȡֵ0��1��2��3
	 * @param yes true��ʾ������false��ʾ������
	 */
	public void setPermission(int permission,boolean yes){
		int tmp = 1;
		tmp = tmp << permission;
		if(yes){
			aclState |= tmp;
		}else{
			aclState &= ~tmp;
		}
	}
	
	/**
	 * ���ACL��Ȩ
	 * @param permission C/R/U/DȨ��
	 * @return ��Ȩ��ʶ������/������/��ȷ��
	 */
	public int getPermission(int permission){
		
		//����̳У��򷵻�δȷ������Ȩ��Ϣ
		if(aclTriState == 0xFFFFFFFF){
			return ACL_NEUTRAL;
		}
		
		int tmp = 1;
	
		tmp = tmp << permission;
		
		tmp &= aclState;
		
		if(tmp != 0){
			return ACL_YES;
		}
		
		return ACL_NO;
	}
	
	/**
	 * ���ñ���Ȩ�Ƿ�̳�
	 * @param yes true��ʾ�̳У�false��ʾ���̳�
	 */
	public void setExtends(boolean yes){
		if(yes){
			aclTriState = 0xFFFFFFFF;
		}else{
			aclTriState = 0;
		}
	}
}
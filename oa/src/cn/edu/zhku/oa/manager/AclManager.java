package cn.edu.zhku.oa.manager;

import java.util.List;

public interface AclManager {
	
	/**
	 * ��Ȩ
	 * @param principalType ��������
	 * @param principalSn �����ʶ
	 * @param resourceSn ��Դ��ʶ
	 * @param permission Ȩ�ޣ�C/R/U/D
	 * @param yes �Ƿ�������true��ʾ������false��ʾ������
	 */
	public void addOrUpdatePermission(
			String principalType,
			int principalSn,
			int resourceSn,
			int permission,
			boolean yes
	);
	
	/**
	 * ɾ����Ȩ
	 * @param principalType
	 * @param principalSn
	 * @param resourceSn
	 */
	public void delPermission(
			String principalType,
			int principalSn,
			int resourceSn
	);
	
	/**
	 * ���ӻ�����û��ļ̳�����
	 * @param userId �û���ʶ
	 * @param resourceSn ��Դ��ʶ
	 * @param yes true��ʾ�̳�,false��ʾ���̳�
	 */
	public void addOrUpdateUserExtends(
			int userId,
			int resourceSn,
			boolean yes
	);
	
	/**
	 * �ж��û���ĳģ���ĳ��������Ȩ��������������
	 * @param userId �û���ʶ
	 * @param reourceSn ��Դ��ʶ(id)
	 * @param permission Ȩ�ޣ�C/R/U/D��
	 * @return ������true����������false��
	 */
	public boolean hasPermission(int userId,int resouceId,int permission);
	
	/**
	 * �ж��û���ĳģ���ĳ��������Ȩ��������������
	 * @param userId �û�ID
	 * @param reourceSn ��ԴΨһ��ʶ��sn��
	 * @param permission Ȩ�ޣ�C/R/U/D��
	 * @return ������true����������false��
	 */
	public boolean hasPermissionByResourceSn(
			int userId,
			String resourceSn,
			int permission
	);
	
	/**
	 * ����ĳ���û�ӵ�ж�ȡȨ�޵�ģ���б������ڵ�¼���γɵ����˵���ʱ��
	 * @param userId �û���ʶ
	 * @return ģ���б������б���Ԫ����Module����
	 */
	public List searchModules(int userId);
	
	/**
	 * �����������ͺ������ʶ����ACL��¼
	 * @param principalType
	 * @param principalSn
	 * @return
	 */
	public List searchAclRecord(String principalType,int principalSn);
}
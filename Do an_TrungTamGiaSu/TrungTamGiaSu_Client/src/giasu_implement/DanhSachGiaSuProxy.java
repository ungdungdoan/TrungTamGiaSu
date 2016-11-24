package giasu_implement;

public class DanhSachGiaSuProxy implements giasu_implement.DanhSachGiaSu {
  private String _endpoint = null;
  private giasu_implement.DanhSachGiaSu danhSachGiaSu = null;
  
  public DanhSachGiaSuProxy() {
    _initDanhSachGiaSuProxy();
  }
  
  public DanhSachGiaSuProxy(String endpoint) {
    _endpoint = endpoint;
    _initDanhSachGiaSuProxy();
  }
  
  private void _initDanhSachGiaSuProxy() {
    try {
      danhSachGiaSu = (new giasu_implement.DanhSachGiaSuServiceLocator()).getDanhSachGiaSu();
      if (danhSachGiaSu != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)danhSachGiaSu)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)danhSachGiaSu)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (danhSachGiaSu != null)
      ((javax.xml.rpc.Stub)danhSachGiaSu)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public giasu_implement.DanhSachGiaSu getDanhSachGiaSu() {
    if (danhSachGiaSu == null)
      _initDanhSachGiaSuProxy();
    return danhSachGiaSu;
  }
  
  public java.lang.String getDSGS() throws java.rmi.RemoteException{
    if (danhSachGiaSu == null)
      _initDanhSachGiaSuProxy();
    return danhSachGiaSu.getDSGS();
  }
  
  
}
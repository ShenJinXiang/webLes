package com.aisino.ws;

public class IEInvWebServicePortTypeProxy implements com.aisino.ws.IEInvWebServicePortType {
  private String _endpoint = null;
  private com.aisino.ws.IEInvWebServicePortType iEInvWebServicePortType = null;
  
  public IEInvWebServicePortTypeProxy() {
    _initIEInvWebServicePortTypeProxy();
  }
  
  public IEInvWebServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initIEInvWebServicePortTypeProxy();
  }
  
  private void _initIEInvWebServicePortTypeProxy() {
    try {
      iEInvWebServicePortType = (new com.aisino.ws.IEInvWebServiceLocator()).getIEInvWebServiceHttpPort();
      if (iEInvWebServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iEInvWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iEInvWebServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iEInvWebServicePortType != null)
      ((javax.xml.rpc.Stub)iEInvWebServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.aisino.ws.IEInvWebServicePortType getIEInvWebServicePortType() {
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType;
  }
  
  public java.lang.String eiInterfpxz(java.lang.String in0) throws java.rmi.RemoteException{
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType.eiInterfpxz(in0);
  }
  
  public java.lang.String eiInterface(java.lang.String in0) throws java.rmi.RemoteException{
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType.eiInterface(in0);
  }
  
  
}
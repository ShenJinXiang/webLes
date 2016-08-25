package com.aisino.balance.ws;

public class IEInvWebServicePortTypeProxy implements com.aisino.balance.ws.IEInvWebServicePortType {
  private String _endpoint = null;
  private com.aisino.balance.ws.IEInvWebServicePortType iEInvWebServicePortType = null;
  
  public IEInvWebServicePortTypeProxy() {
    _initIEInvWebServicePortTypeProxy();
  }
  
  public IEInvWebServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initIEInvWebServicePortTypeProxy();
  }
  
  private void _initIEInvWebServicePortTypeProxy() {
    try {
      iEInvWebServicePortType = (new com.aisino.balance.ws.IEInvWebServiceLocator()).getIEInvWebServiceHttpPort();
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
  
  public com.aisino.balance.ws.IEInvWebServicePortType getIEInvWebServicePortType() {
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType;
  }
  
  public java.lang.String fpkccxInterface(java.lang.String in0) throws java.rmi.RemoteException{
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType.fpkccxInterface(in0);
  }
  
  public java.lang.String djxxcxInterface() throws java.rmi.RemoteException{
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType.djxxcxInterface();
  }
  
  public java.lang.String fpkjInterface(java.lang.String in0) throws java.rmi.RemoteException{
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType.fpkjInterface(in0);
  }
  
  public java.lang.String fpcyInterface(java.lang.String in0) throws java.rmi.RemoteException{
    if (iEInvWebServicePortType == null)
      _initIEInvWebServicePortTypeProxy();
    return iEInvWebServicePortType.fpcyInterface(in0);
  }
  
  
}
package coreservice;

import java.rmi.RemoteException;

public class CoreservicePortTypeProxy implements coreservice_pkg.CoreservicePortType {
  private String _endpoint = null;
  private coreservice_pkg.CoreservicePortType coreservicePortType = null;
  
  public CoreservicePortTypeProxy() {
    _initCoreservicePortTypeProxy();
  }
  
  public CoreservicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCoreservicePortTypeProxy();
  }
  
  private void _initCoreservicePortTypeProxy() {
    try {
      coreservicePortType = (new coreservice_pkg.CoreserviceLocator()).getcoreserviceHttpPort();
      if (coreservicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)coreservicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)coreservicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (coreservicePortType != null)
      ((javax.xml.rpc.Stub)coreservicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public coreservice_pkg.CoreservicePortType getCoreservicePortType() {
    if (coreservicePortType == null)
      _initCoreservicePortTypeProxy();
    return coreservicePortType;
  }

@Override
public String handler(String in0) throws RemoteException {
	if(coreservicePortType == null) {
		_initCoreservicePortTypeProxy();
	}
	return coreservicePortType.handler(in0);
}
  
  
}
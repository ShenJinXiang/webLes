/**
 * Coreservice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package coreservice;

public interface Coreservice extends javax.xml.rpc.Service {
    public java.lang.String getcoreserviceHttpPortAddress();

    public coreservice.CoreservicePortType getcoreserviceHttpPort() throws javax.xml.rpc.ServiceException;

    public coreservice.CoreservicePortType getcoreserviceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

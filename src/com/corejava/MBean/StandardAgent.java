package com.corejava.MBean;

import javax.management.*;

/**
 * Class Name : StandardAgent<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1611:11<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class StandardAgent {
    private MBeanServer mBeanServer = null;

    public StandardAgent() {
        mBeanServer = MBeanServerFactory.newMBeanServer();
    }

    public MBeanServer getMBeanServer() {
        return mBeanServer;
    }

    public ObjectName createObjectName(String name){
        ObjectName objectName = null;
        try {
            objectName = new ObjectName(name);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        return objectName;
    }

    public void createStandardBean(ObjectName objectName,String managerdResoutceClassName) {
        try {
            mBeanServer.createMBean(managerdResoutceClassName,objectName);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        StandardAgent agent = new StandardAgent();
        MBeanServer mBeanServer = agent.getMBeanServer();
        String domain = mBeanServer.getDefaultDomain();
        String managedResoutceClassName = "com.corejava.MBean.Car";
        ObjectName objectName = agent.createObjectName(domain + ":type=" + managedResoutceClassName);
        System.out.println("objectName: " + objectName);
        agent.createStandardBean(objectName,managedResoutceClassName);
        Attribute colorAttribute = new Attribute("Color","blue");
        try {
            mBeanServer.setAttribute(objectName,colorAttribute);
            System.out.println(mBeanServer.getAttribute(objectName,"Color"));
            mBeanServer.invoke(objectName,"drive",null,null);
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        }
    }
}

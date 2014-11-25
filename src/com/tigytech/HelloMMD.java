package com.tigytech;

import projectkyoto.jme3.mmd.CartoonEdgeProcessor;
import projectkyoto.jme3.mmd.PMDLoaderGLSLSkinning2;
import projectkyoto.jme3.mmd.PMDNode;
import projectkyoto.jme3.mmd.VMDLoader;
import projectkyoto.mmd.file.VMDFile;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;

public class HelloMMD extends SimpleApplication {
	public static void main(String[] args) {
		HelloMMD app = new HelloMMD();
		app.start();
	}
	
	public void simpleInitApp() {
		try {
	        assetManager.registerLoader(PMDLoaderGLSLSkinning2.class, "pmd");
	        assetManager.registerLoader(VMDLoader.class, "vmd");
	        
	        PMDNode pmdNode = (PMDNode) assetManager.loadModel("/Model/miku.pmd");
	        VMDFile vmd = (VMDFile) assetManager.loadAsset("/motion/gomyway.vmd");
	        rootNode.attachChild(pmdNode);
	        pmdNode.scale(0.5f);
	        CartoonEdgeProcessor cartoonEdgeProcess = new CartoonEdgeProcessor();
	        viewPort.addProcessor(cartoonEdgeProcess);
	        PointLight pl = new PointLight();
	        pl.setColor(ColorRGBA.White.mult(0.5f));
	        pl.setRadius(2f);

	        DirectionalLight dl = new DirectionalLight();
	        dl.setDirection(new Vector3f(1, 0, -5).normalizeLocal());
	        dl.setColor(ColorRGBA.White.mult(0.5f));
	        rootNode.addLight(dl);
	        AmbientLight al = new AmbientLight();
	        al.setColor(ColorRGBA.White.mult(1.2f));
	        pmdNode.addLight(al);
	        
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

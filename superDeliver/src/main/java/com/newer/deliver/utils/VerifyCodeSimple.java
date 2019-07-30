package com.newer.deliver.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCodeSimple {

	// 用来产生随机数中的字符
	private static String str = "aqzxswedcfrvgtbhyujklp23456789";
	public static Random random = new Random();

	/**
	 * 产生两个范围之类的随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int r(int min, int max) {
		int num = 0;
		num = random.nextInt(max - min) + min;
		return num;
	}

	/**
	 * 生成验证码，
	 * 
	 * @param len
	 *            验证码长度
	 * @return
	 */
	public static String generateVerifyCode(int len) {
		StringBuilder sb = new StringBuilder();

		int strLen = str.length();
		for (int i = 0; i < len; i++) {
			sb.append(str.charAt(random.nextInt(strLen - 1)));
		}
		return sb.toString();
	}

	/**
	 * 将验证码图象写入OutputStream
	 * 
	 * @param w
	 * @param h
	 * @param out
	 */
	public static void outputImage(int w, int h, OutputStream out, String code) {
		// 在内存中创建一幅图画
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		// 在图片上画一个矩形当背景
		Graphics g = img.getGraphics();
		
		//设置随机颜色
		int red=r(50,250);
		int green=r(50,250);
		int blue=r(50,250);
		Color color=new Color(red,green,blue);
		g.setColor(color);
		
		//填充一个矩形
		g.fillRect(0, 0, w, h);
		//g.fillArc(0,0, w, h, 1, 2);
		//填充随机数
		for(int i=0;i<code.length();i++){
			g.setColor(new Color(r(50, 180), r(50, 180), r(50, 180)));
			//黑体、Algerian /Font.PLAIN 
			g.setFont(new Font("Algerian", Font.ITALIC, 40));
			char c = code.charAt(i);
			g.drawString(String.valueOf(c), 10 + i * 30, r(h - 30, h));
			
		}
		//System.out.println("code3:"+code);

		// 画随机线
		for (int i = 0; i < 10; i++) {
			g.setColor(new Color(r(50, 180), r(50, 180), r(50, 180)));
			g.drawLine(r(0, w), r(0, h), r(0, w), r(0, h));
		}
		// 把内存中创建的图像输出至OutputStream
		try {
			ImageIO.write(img, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		System.out.println(r(7,9));
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class utilsGraficos {

    public utilsGraficos() {

    }

    public void configurarResponsividad(JPanel pnlFondo, int width, int height) {
        pnlFondo.setBounds(((pnlFondo.getX() * width / 1280)), ((pnlFondo.getY() * height / 720)), ((pnlFondo.getWidth() * width / 1280)), ((pnlFondo.getHeight() * height / 720)));
        Component[] components = pnlFondo.getComponents();
        // Itera a través de los componentes y muestra información sobre cada uno
        for (Component component : components) {
            dimensionComponenteResponsive(component, width, height);
            if (component instanceof JLabel) {
                double proporcion = component.getFont().getSize() / 1280f;
            }
        }
    }

    public void setImageButton(JButton jbutton, int rp) {
        ImageIcon image = new ImageIcon(iconToImage(jbutton.getIcon()));
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(jbutton.getWidth(), jbutton.getHeight(), Image.SCALE_DEFAULT));
        jbutton.setIcon(icono);
        if (jbutton.getDisabledIcon() != null) {
            ImageIcon imageDisabled = new ImageIcon(iconToImage(jbutton.getDisabledIcon()));
            Icon iconoDisabled = new ImageIcon(imageDisabled.getImage().getScaledInstance(jbutton.getWidth(), jbutton.getHeight(), Image.SCALE_DEFAULT));
            jbutton.setDisabledIcon(iconoDisabled);
        }
    }

    public void dimensionComponenteResponsive(Component component, int width, int height) {
        component.setBounds(((component.getX() * width) / 1280), ((component.getY() * height) / 720), ((component.getWidth() * width) / 1280), ((component.getHeight() * height) / 720));
        if (component instanceof JButton) {
            if (((JButton) component).getIcon() != null) {
                setImageButton((JButton) component, 1);
            }
        }
        if (component instanceof JLabel) {
            if (((JLabel) component).getIcon() != null) {
                setImageLabel((JLabel) component, 1);
            }
        }
    }

    public void setImageButton(JPanel pnlFondo, JButton jbutton, int rp) {
        ImageIcon image = new ImageIcon(iconToImage(jbutton.getIcon()));
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(jbutton.getWidth(), jbutton.getHeight(), Image.SCALE_DEFAULT));
        jbutton.setIcon(icono);
        if (jbutton.getDisabledIcon() != null) {
            ImageIcon imageDisabled = new ImageIcon(iconToImage(jbutton.getDisabledIcon()));
            Icon iconoDisabled = new ImageIcon(imageDisabled.getImage().getScaledInstance(jbutton.getWidth(), jbutton.getHeight(), Image.SCALE_DEFAULT));
            jbutton.setDisabledIcon(iconoDisabled);
        }
        //la variable rp indica si se repintara o no
        if (rp == 1) {
            pnlFondo.repaint();
        }
    }

    public void setImageLabel(JLabel jlabel, int rp) {
        ImageIcon image = new ImageIcon(iconToImage(jlabel.getIcon()));
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_DEFAULT));
        jlabel.setIcon(icono);
        
    }

    public static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            int width = icon.getIconWidth();
            int height = icon.getIconHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.getGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }
}

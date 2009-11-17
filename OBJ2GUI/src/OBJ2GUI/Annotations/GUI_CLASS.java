package OBJ2GUI.Annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface GUI_CLASS {
	
	/** Enumération des différents niveaux de criticités. 
	 * BoxLayout : LINE, PAGE, X, Y
	 * FlowLayout : LEFT TO RIGHT, RIGHT TO LEFT
	 * GridLayout : Nombre de Colonne, et de rangée ?!
	 * Absolute : Il faut une taille de panel je pense + la position de chaque field (si pas de position alors mettre en Y Layout style
	 */
	public static enum Type {BoxLayout, FlowLayout, GridLayout, Absolute, TabbedPane, TreePane/*, CardLayout*/};
	public static enum Type_BoxLayout {LINE, PAGE, X, Y};
	public static enum Type_FlowLayout {LEFT, CENTER, RIGHT}
	
	
	
	Type type() default Type.BoxLayout;
	Type_BoxLayout BoxLayout_property() default Type_BoxLayout.Y;
	Type_FlowLayout FlowLayout_property() default Type_FlowLayout.CENTER;
	int 			   Type_GridLayout_ROWS    () default -1;
	int 			   Type_GridLayout_COLUMNS () default -1;

}


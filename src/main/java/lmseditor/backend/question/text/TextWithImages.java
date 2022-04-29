package lmseditor.backend.question.text;

import lmseditor.backend.image.ImageList;
import org.eclipse.persistence.oxm.annotations.XmlCDATA;
import lmseditor.backend.question.text.format.Formatter;
import lmseditor.backend.question.text.format.HtmlFormatter;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextWithImages {

    @XmlAttribute
    private String format;

    @XmlElement(name = "text")
    @XmlCDATA
    protected String xmlText;

    @XmlPath(".")
    private ImageList imageList;

    @XmlPath(".")
    private Text text;

    @XmlTransient
    private Formatter formatter;

    public TextWithImages() {
        this.formatter = new HtmlFormatter();
        this.xmlText = "";
        this.imageList = new ImageList();
        this.text = new Text();
        this.format = formatter.getFormatOption();
    }

    public ImageList getImageList() {
        return imageList;
    }

    public void setImageList(ImageList imageList) {
        this.imageList = imageList;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void generateFormattedText() {
        formatter.setText(text.getText());
        formatter.setImageList(imageList);
        xmlText = formatter.getFormattedString();
    }

}

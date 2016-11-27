package com.rain.learn.sms.view.tags;

import java.util.Map;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.AbstractFormTag;
import org.springframework.web.servlet.tags.form.TagWriter;

@SuppressWarnings("serial")
public class CommonTag extends AbstractFormTag {
    private String modelAttribute;

    public void setModelAttribute(String modelAttribute) {
        this.modelAttribute = modelAttribute;
    }

    public String getModelAttribute() throws JspException {
        String resolvedModelAttribute = (String) evaluate("modelAttribute", this.modelAttribute);
        return (resolvedModelAttribute != null ? resolvedModelAttribute : "");
    }

    @Override
    protected int writeTagContent(TagWriter tagWriter) throws JspException {
        Object model;
        if (getRequestContext().getModel() != null)
            model = getRequestContext().getModel().get(getModelAttribute());
        else
            model = this.pageContext.getRequest().getAttribute(getModelAttribute());
        if (model == null) {
            return EVAL_BODY_INCLUDE;
        }
        Map<Validate, String> map = TagUtil.genTagRulesAndMessages(model, null, null, getRequestContext());

        tagWriter.startTag("script");
        tagWriter.writeAttribute("type", "text/javascript");
        tagWriter.appendValue("$(function() {");
        tagWriter.appendValue("$(\"#");
        tagWriter.appendValue(getModelAttribute());
        tagWriter.appendValue("\").validate({");
        tagWriter.appendValue("onfocusout:function(element){$(element).valid();},");
        tagWriter.appendValue(map.get(Validate.RULE));
        tagWriter.appendValue(",");
        tagWriter.appendValue(map.get(Validate.MESSAGE));
        tagWriter.appendValue("});");
        tagWriter.appendValue("});");
        tagWriter.endTag(true);

        return EVAL_BODY_INCLUDE;
    }

}

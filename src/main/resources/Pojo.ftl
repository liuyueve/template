package ${packageName};

<#list imports>
    <#items as import>
import ${import};
    </#items>
</#list>

public class ${beanName} {

<#list typeMap>
    <#items as type>
    private ${type.type} ${type.name};
    </#items>
</#list>

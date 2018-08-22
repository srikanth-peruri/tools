<div class="bPageBlock brandSecondaryBrd secondaryPalette">
	<div class="pbHeader"/>
	<div class="pbBody">
		<table class="list" border="1" cellspacing="0" cellpadding="0">
			<tbody>
				<tr class="headerRow">
					<th>Checkbox</th>
					<#list fieldInfoList as col>
						<th>${col.fieldLabel}</th>
					</#list>
				</tr>
				<#assign count = 0>
				<#assign rowsCount = resultsList?size>
				<#list resultsList as list>
					<tr class="dataRow <#if count%2 == 0>even<#else>odd</#if>" onblur="if (window.hiOff){hiOff(this);}" onfocus="if (window.hiOn){hiOn(this);}" onmouseout="if (window.hiOff){hiOff(this);}" onmouseover="if (window.hiOn){hiOn(this);}">
						<#assign tableCellIndex = 0>
						<#assign tableCellsCount = list?size>
						<#list list as value>
							<#if tableCellIndex == 0>
							  	<th scope="row" class=" dataCell  booleanColumn">
									<input id="cid${count}" name="cid" title="Select row ${count}" type="checkbox" value="${list[tableCellsCount-1]}" <#if rowsCount <= 3 >checked=checked<#else></#if>>
								</th>
							</#if>		
							<td class=" dataCell  ">${value}</td>
							<#assign tableCellIndex++>
						</#list>		
					</tr>
					<#assign count++>
				</#list>
			</tbody>
		</table>
	</div>
	<div class="pbFooter secondaryPalette">
		<div class="bg"/>
	</div>
</div>
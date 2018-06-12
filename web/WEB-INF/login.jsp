<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.pjatk.hibernate_mds.models.EtlProcessLogModel" %>
<%@ page import="pl.pjatk.hibernate_mds.services.EtlProcessItemService" %>
<%@ page import="pl.pjatk.hibernate_mds.models.EtlProcItemModel" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.pjatk.hibernate_mds.models.EtlVariableModel" %>
<%@ page import="pl.pjatk.hibernate_mds.services.EtlVariableService" %>
<html>
<style type="text/css">


    .text{


    }
    body{
        font-family: verdana;
        font-size: 12px;
        margin: 10px;
    }
    * {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }
    .table{
        width: 100%;
    }
    .table .tableRow{
        width: 100%;
        float: left;
        /*border-bottom: 1px solid #ccc;*/
    }

    .table .tableRow .tableCell{
        float: left;
        padding: 10px;
        width: 25%;
        /*border-right: 1px solid #ccc;*/
    }
    .tableCell
    .open{
        float: right;
    }
    .table .tableRow .tableCell:first-child{
        /*border-left: 1px solid #ccc;*/
    }
    .table .tableRow:first-child{
        /*border-top: 1px solid #ccc;*/

    }
    .table .subTables{
        display: none;
        width: 100%;
        float: left;
        border-bottom: none;
    }
    .cellBorderTop{
        border-top: 1px solid lightblue;
    }
    .inwardTable
    .tableCell:nth-child(1){
        width: 5%;
    }
    .inwardTable
    .tableCell:nth-child(2){
        width: 15%;
    }
    .inwardTable
    .tableCell:nth-child(3){
        width: 10%;
    }
    .inwardTable
    .tableCell:nth-child(4){
        width: 17%;
    }
    .inwardTable
    .tableCell:nth-child(5){
        width: 17%;
    }
    .inwardTable
    .tableCell:nth-child(6){
        width: 10%;
    }
    .inwardTable
    .tableCell:nth-child(7){
        width: 11%;
    }
    .inwardTable
    .tableCell:nth-child(8){
        width: 15%;
    }
</style>
<head>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <title>ETL Monitor Tool v 0.1</title>
</head>
<body style="background: linear-gradient(45deg, #a8edea, #fed6e3);">

<div class="text" style="font-size: x-large">
    <b><center><p><i>ETL Monitor Tool</i></p></center></b>
</div>
<div class="text1" style="font-size: medium">
    <b><center><p><i>v 0.1</i></p></center></b>
</div>



<div class='inwardTable'>
    <div class="table" >
        <div class="tableRow tableTitle" >
            <div class="tableCell">

            </div>
            <div class="tableCell">
               <b>Process ID</b>
            </div>
            <div class="tableCell">
                <b>Date</b>
            </div>
            <div class="tableCell">
                <b>Description</b>
            </div>
            <div class="tableCell">
                <b>Start Time</b>
            </div>
            <div class="tableCell">
                <b>End Time</b>
            </div>
            <div class="tableCell">
                <b>Status</b>
            </div>
            <div class="tableCell">
                <b>Created by</b>
            </div>
        </div>

<% ArrayList users = (ArrayList)request.getAttribute("procs");
    //String today = (String)request.getAttribute("today");
    //out.print(today);
    EtlProcessItemService itemservice = new EtlProcessItemService();
    List<EtlProcItemModel> items = new ArrayList<>();

    EtlVariableService variableService = new EtlVariableService();
    List<EtlVariableModel> variables = new ArrayList<>();
    for (int i = 0; i < users.size(); i++) {
        EtlProcessLogModel user = (EtlProcessLogModel) users.get(i);
        items = itemservice.findbyProcess(user.getProcessId());
        variables = variableService.findByProcess(user.getProcessId());
         %>
<div class='inwardTable'>
    <div class="table">
        <div class="tableRow tableTitle" style="background: lightblue">
            <div class="tableCell">

            </div>

        </div>


        <div class="tableRow">
            <div class="tableCell">
                <a href="javascript:void(0);" class="open"><i class="glyphicon glyphicon-chevron-down"></i></a>
            </div>
            <div class="tableCell">
                <td><% out.print(user.getProcessId());%></td>
            </div>
            <div class="tableCell">
                <td><% out.print(user.getCalendar()); %></td>
            </div>
            <div class="tableCell">
                <td><% out.print(user.getDescription()); %></td>

            </div>
            <div class="tableCell">
                <td><% out.print(user.getStartTm()); %></td>
            </div>
            <div class="tableCell">
                <td><% out.print(user.getEndTm()); %></td>
            </div>
            <div class="tableCell">
                <td><% out.print(user.getStatus()); %></td>
            </div>
            <div class="tableCell">
                <td><% out.print(user.getCreatedBy());%></td>
            </div>
            <% for (int j = 0; j < items.size(); j++){
                EtlProcItemModel itemm = (EtlProcItemModel) items.get(j); %>
            <div class="subTables">
                <div class='rowSubTable'>
                    <div class="tableCell">
                        &nbsp;
                    </div>

                    <div class="tableCell cellBorderTop">
                        <td><b>Item Id</b> </td>
                        <br><% out.print(itemm.getItemId());%>
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>Item Type</b> <br> <% out.print(itemm.getItemType());%></td>
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>Target</b> <br> <% out.print(itemm.getOraTarget());%></td>
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>Item Order</b> <br> <% out.print(itemm.getItemOrder());%></td>
                    </div>

                </div>

            </div>

            <% for (int n = 0; n < variables.size(); n++){
                 EtlVariableModel variable = (EtlVariableModel) variables.get(n); %>
            <div class="subTables">
                <div class='rowSubTable'>
                    <div class="tableCell">
                        &nbsp;
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>Variable Name</b> </td>
                        <br><% out.print(variable.getVarName());%>
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>Enviroment Name</b> <br> <% out.print(variable.getEnviromentName());%></td>
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>SQL</b> <br> <% out.print(variable.getVarSql());%></td>
                    </div>
                    <div class="tableCell cellBorderTop">
                        <td><b>Description</b> <br> <% out.print(variable.getDescription());%></td>
                    </div>

                </div>
                <% } %>
            </div>


        </div>
</div>
        <% } %>
        <% } %>
<script type="text/javascript">
    $(document).ready(function() {
        $('.subTables').hide();
        $('.open').on('click', function() {
            $(this).parent('div').parent('div').find('.subTables').slideToggle();
            //$(this).find('.glyphicon-chevron-down').toggleClass('glyphicon-chevron-up');
            if ($(this).find('i').hasClass('glyphicon-chevron-down')) {
                $(this).find('i').removeClass('glyphicon-chevron-down');
                $(this).find('i').addClass('glyphicon-chevron-up');
            } else {
                $(this).find('i').removeClass('glyphicon-chevron-up');
                $(this).find('i').addClass('glyphicon-chevron-down');
            }
        });

        $("#checkAll").change(function(){
            var status = $(this).is(":checked") ? true : false;
            $(".checkChange").prop("checked",status);
        });
    });
</script>
</body>

</html>
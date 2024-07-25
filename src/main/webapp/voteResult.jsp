<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.EventDataBeans" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>投票結果画面</title>
    <style>
        .highlight {
            background-color: yellow;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>投票ありがとうございます！</h1>
    <table border="1">
        <tr>
            <th>イベント名</th>
            <th>投票数</th>
            <th>投票割合</th>
        </tr>
        <%
            List<EventDataBeans> eventDataBeans = (List<EventDataBeans>) request.getAttribute("eventData");
            int totalVotes = (int) request.getAttribute("totalVotes");

            int maxVotes = 0;
            for (EventDataBeans event : eventDataBeans) {
                if (event.getVoteCount() > maxVotes) {
                    maxVotes = event.getVoteCount();
                }
            }
            for (EventDataBeans event : eventDataBeans) {
                int voteCount = event.getVoteCount();
                double votePercentage = totalVotes > 0 ? (double) voteCount / totalVotes * 100 : 0;
                String highlightClass = (voteCount == maxVotes) ? "highlight" : "";
        %>
        <tr class="<%= highlightClass %>">
            <td><%= event.getName() %></td>
            <td><%= voteCount %></td>
            <td><%= String.format("%.2f", votePercentage) %> %</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

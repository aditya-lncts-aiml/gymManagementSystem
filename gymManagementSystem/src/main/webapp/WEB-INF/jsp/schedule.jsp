<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Class Schedule</title>
    <style>
       <%@include file="/WEB-INF/css/schedule.css">
    </style>
    <script>
        function toggleDay(day) {
            const dayElements = document.querySelectorAll('.day');
            dayElements.forEach(el => el.classList.remove('active'));
            day.classList.add('active');

            const timeSlots = document.querySelectorAll('.time-slot');
            timeSlots.forEach(slot => slot.classList.remove('active'));
            const selectedSlot = document.getElementById(day.dataset.target);
            if (selectedSlot) {
                selectedSlot.classList.add('active');
            }
        }
    </script>
</head>
<body>
    <div class="schedule-container">
    <h2 align="center" style="color: white; height: 20px;" >Class-Schedule</h2>
        <div class="class-schedule">
            <div class="day active" data-target="sunday" onclick="toggleDay(this)">Sunday</div>
            <div class="day" data-target="monday" onclick="toggleDay(this)">Monday</div>
            <div class="day" data-target="tuesday" onclick="toggleDay(this)">Tuesday</div>
            <div class="day" data-target="wednesday" onclick="toggleDay(this)">Wednesday</div>
            <div class="day" data-target="thursday" onclick="toggleDay(this)">Thursday</div>
            <div class="day" data-target="friday" onclick="toggleDay(this)">Friday</div>
            <div class="day" data-target="saturday" onclick="toggleDay(this)">Saturday</div>
        </div>
        <div class="time-slots">
            <div id="sunday" class="time-slot active">
                <p>Cardio: 7:00 AM - 8:00 AM (Angel Adams)</p>
            </div>
            <div id="monday" class="time-slot">
                <!-- Add Monday's schedule here -->
            </div>
            <div id="tuesday" class="time-slot">
                <p>Body Building: 9:00 AM - 11:00 AM (Angel Adams)</p>
            </div>
            <div id="wednesday" class="time-slot">
                <!-- Add Wednesday's schedule here -->
            </div>
            <div id="thursday" class="time-slot">
                <p>Yoga: 6:00 AM - 7:00 AM (Angel Adams)</p>
            </div>
            <div id="friday" class="time-slot">
                <!-- Add Friday's schedule here -->
            </div>
            <div id="saturday" class="time-slot">
                <p>Boxing: 7:00 AM - 8:00 AM (Angel Adams)</p>
            </div>
        </div>
    </div>
</body>
</html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/3/2022
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<style>
    h5 {
        color: red;
    }
</style>
</head>
<body>
<div class="container">
    <form:form method="post" action="create" modelAttribute="medicalDeclaration">
        <h1 style="text-align: center">TỜ KHAI Y TẾ</h1>
        <h1 style="text-align: center;font-size: 15px">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN
            Y
            TẾ LIÊN LẠC KHI CÀN THIẾT ĐẺ PHÒNG CHÓNG DỊCH
            BỆNH TRUYỀN NHIỄM
        </h1>
        <h1 style="color: red;text-align: center;font-size: 20px">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp
            luật
            Việt Nam và có thể xử lý hình sự
        </h1><br><br>
        <div>
            <form:label path="name" cssStyle="font-weight: bold">Họ tên (ghi chữ IN HOA) <span
                    style="color: red">(*)</span></form:label>
            <h5>${medicalDeclaration.name}</h5>


        </div>
        <div style="width: 33.33%;float: left;">
            <form:label path="birthday" cssStyle="font-weight: bold">Năm sinh <span
                    style="color: red">(*)</span></form:label>
            <h5>${medicalDeclaration.birthday}</h5>
        </div>
        <div style="width: 33.33%;float: left;">
            <form:label path="gender" cssStyle="font-weight: bold">Giới tính <span
                    style="color: red">(*)</span></form:label>
            <h5>${medicalDeclaration.gender}</h5>
        </div>
        <div style="width: 33.33%;float: left;">
            <form:label path="nationality" cssStyle="font-weight: bold">Quốc tịch <span
                    style="color: red">(*)</span></form:label>
            <h5>${medicalDeclaration.nationality}</h5>
        </div>
        <div>
            <form:label path="passport"
                        cssStyle="font-weight: bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                    style="color: red">(*)</span></form:label>
            <div>
                <h5>${medicalDeclaration.passport1}--${medicalDeclaration.passport}</h5>
            </div>
            <div>
                <form:label path="move" cssStyle="font-weight: bold">Thông tin đi lại <span
                        style="color: red">(*)</span>
                </form:label>
                <div style="font-weight: bold">
                    <h5>${medicalDeclaration.move}${medicalDeclaration.moveOther}</h5>
                </div>
            </div>
            <div style="width: 50%;float: left;">
                <form:label path="vehicleNumber" cssStyle="font-weight: bold">Số hiệu phương tiện <span
                        style="color: red">(*)</span></form:label>
                <h5>${medicalDeclaration.vehicleNumber}</h5>
            </div>
            <div style="width: 50%;float: right;">
                <form:label path="seats" cssStyle="font-weight: bold">Số ghế <span
                        style="color: red">(*)</span></form:label>
                <h5>${medicalDeclaration.seats}</h5></div>
            <div style="width: 50%;float: left;">
                <div>
                    <form:label path="departureDay" cssStyle="font-weight: bold">Ngày khởi hành <span
                            style="color: red">(*)</span></form:label></div>
                <h5>${medicalDeclaration.departureDay}-${medicalDeclaration.departureMonth}-${medicalDeclaration.departureYear}</h5>
            </div>
            <div style="width: 50%;float: right;">
                <div>
                    <form:label path="endDate" cssStyle="font-weight: bold">Ngày kết thúc <span
                            style="color: red">(*)</span></form:label></div>
                <h5>${medicalDeclaration.endDate}-${medicalDeclaration.endMonth}-${medicalDeclaration.endYear}</h5>

            </div>
            <div>
                <form:label path="moved14day"
                            cssStyle="font-weight: bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành
                    phố nào? <span
                            style="color: red">(*)</span></form:label>
                <h5>${medicalDeclaration.moved14day}</h5>
            </div>
            <br>
            <h4 style="font-weight: bold">Địa chỉ liên lạc</h4>
            <div style="width: 33.33%;float: left;">
                <form:label path="city" cssStyle="font-weight: bold">Tỉnh / thành <span
                        style="color: red">(*)</span></form:label>
                <h5>${medicalDeclaration.city}</h5>
            </div>
            <div style="width: 33.33%;float: left;">
                <form:label path="district" cssStyle="font-weight: bold">Quận / huyện <span
                        style="color: red">(*)</span></form:label>
                <h5>${medicalDeclaration.district}</h5>
            </div>
            <div style="width: 33.33%;float: left;">
                <form:label path="ward" cssStyle="font-weight: bold">Phường / xã <span
                        style="color: red">(*)</span></form:label>
                <h5>${medicalDeclaration.ward}</h5>
            </div>
            <div>
                <form:label path="symptom"
                            cssStyle="font-weight: bold">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau
                    đây không? <span
                            style="color: red">(*)</span></form:label>
                <div style="width: 49%;float: left">
                    <table border="1px" style="width: 100%">

                        <tr style="height: 50px;background-color: lightblue">
                            <th style="width: 80%;padding-left: 10px">Triệu Chứng</th>
                            <th style="width: 20%;text-align: center"></th>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom" cssStyle="font-weight: bold">Sốt
                                <span
                                        style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom}</td>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom1" cssStyle="font-weight: bold">
                                Ho <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom1}</td>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom2" cssStyle="font-weight: bold">
                                Khó thở <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom2}</td>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom3" cssStyle="font-weight: bold">
                                Đau họng <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom3}</td>

                        </tr>
                    </table>
                </div>
                <div style="width: 49%;float: right">
                    <table border="1px" style="width: 100%">

                        <tr style="height: 50px;background-color: lightblue">
                            <th style="width: 80%;padding-left: 10px">Triệu Chứng</th>
                            <th style="width: 20%;text-align: center"></th>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom4" cssStyle="font-weight: bold">
                                Nôn / buồn nôn <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom4}</td>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom5" cssStyle="font-weight: bold">
                                Tiêu chảy <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom5}</td>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom6" cssStyle="font-weight: bold">
                                Xuất huyết ngoài da <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom6}</td>

                        </tr>
                        <tr>
                            <td style="padding-left: 10px"><form:label path="symptom7" cssStyle="font-weight: bold">
                                Nổi ban da ngoài <span style="color: red">(*)</span></form:label>
                            </td>
                            <td style="text-align: center;color: red">${medicalDeclaration.symptom7}</td>

                        </tr>
                    </table>
                </div>
            </div>
            <div>
                <form:label path="symptom"
                            cssStyle="font-weight: bold">Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span
                        style="color: red">(*)</span></form:label>
                <table border="1px" style="width: 100%">
                    <tr style="height: 30px;background-color: lightblue">
                        <th style="width: 80%"></th>
                        <th style="width: 20%;text-align: center"></th>

                    </tr>
                    <tr>
                        <td style="padding-left: 10px"><form:label path="exposure"
                                                                   cssStyle="font-weight: bold">Đến trang trại chăn nuôi / chợ
                            buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc động vật <span
                                    style="color: red">(*)</span></form:label>
                        </td>
                        <td style="text-align: center;color: red">${medicalDeclaration.exposure}</td>
                    </tr>
                    <tr>
                        <td style="padding-left: 10px"><form:label path="exposure1"
                                                                   cssStyle="font-weight: bold">Tiếp xúc gần
                            (<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span
                                    style="color: red">(*)</span></form:label>
                        </td>
                        <td style="text-align: center;color: red">${medicalDeclaration.exposure1}</td>
                    </tr>
                </table>
            </div>
            <br>
            <p style="color: red;font-weight: bold">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng
                chống
                dịch, thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.
                Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>
        </div>

    </form:form>
</div>
</body>
</html>

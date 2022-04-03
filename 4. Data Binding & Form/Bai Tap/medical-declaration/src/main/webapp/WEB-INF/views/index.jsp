<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/3/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <style>

        form input[type="radio"] {
            padding: 0;
            margin: 0 10px 0 10px;
        }

        form label {
            margin-top: 10px;
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
        <form:input path="name" cssStyle="width: 100%;height: 30px"></form:input>
        <form:errors cssClass="error" path="name"></form:errors>

    </div>
    <div style="width: 33.33%;float: left;">
        <form:label path="birthday" cssStyle="font-weight: bold">Năm sinh <span
                style="color: red">(*)</span></form:label>
        <form:select path="birthday" cssStyle="width: 95%;height: 30px" >
            <form:option value="" label="--Chọn--"></form:option>
            <form:options items="${birthday}"  ></form:options>
        </form:select>
    </div>
    <div style="width: 33.33%;float: left;">
        <form:label path="gender" cssStyle="font-weight: bold">Giới tính <span
                style="color: red">(*)</span></form:label>
        <form:select path="gender" cssStyle="width: 95%;height: 30px" >
            <form:option value="" label="--Chọn--"></form:option>
            <form:options items="${gender}"  ></form:options>
        </form:select>
    </div>
    <div style="width: 33.33%;float: left;">
        <form:label path="nationality" cssStyle="font-weight: bold">Quốc tịch <span
                style="color: red">(*)</span></form:label>
        <form:select path="nationality" cssStyle="width: 100%;height: 30px" >
            <form:option value="" label="--Chọn--"></form:option>
            <form:options items="${nationality}"  ></form:options>
        </form:select>
    </div>
    <div>
        <form:label path="passport"
                    cssStyle="font-weight: bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                style="color: red">(*)</span></form:label>
        <div>
            <form:select path="passport1" cssStyle="width: 31.66%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${passport1}"  ></form:options>
            </form:select>
            <form:input path="passport" cssStyle="width: 66.66%;height: 30px;float: right"></form:input></div>
    </div>
    <div>
        <form:label path="move" cssStyle="font-weight: bold">Thông tin đi lại <span style="color: red">(*)</span>
        </form:label>
        <div style="font-weight: bold">
            <form:radiobuttons path="move" items="${move}"></form:radiobuttons>
            <form:input path="moveOther" cssStyle="width: 61.66%"></form:input>
        </div>
    </div>
    <div style="width: 50%;float: left;">
        <form:label path="vehicleNumber" cssStyle="font-weight: bold">Số hiệu phương tiện <span
                style="color: red">(*)</span></form:label>
        <form:input path="vehicleNumber" cssStyle="width: 95%;height: 30px" placeholder="VD:VN123"></form:input>
    </div>
    <div style="width: 50%;float: right;">
        <form:label path="seats" cssStyle="font-weight: bold">Số ghế <span
                style="color: red">(*)</span></form:label>
        <form:input path="seats" cssStyle="width: 100%;height: 30px"></form:input>
    </div>
    <div style="width: 50%;float: left;">
        <div>
            <form:label path="departureDay" cssStyle="font-weight: bold">Ngày khởi hành <span
                    style="color: red">(*)</span></form:label></div>
        <div style="width: 33.33%;float: left">
            <form:select path="departureDay" cssStyle="width: 90%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${departureDay}"  ></form:options>
            </form:select>
        </div>
        <div style="width: 33.33%;float: left">
            <form:select path="departureMonth" cssStyle="width: 90%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${departureMonth}"  ></form:options>
            </form:select>
        </div>
        <div style="width: 33.33%;float: left">
            <form:select path="departureYear" cssStyle="width: 85%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${departureYear}"  ></form:options>
            </form:select>
        </div>
    </div>
    <div style="width: 50%;float: right;">
        <div>
            <form:label path="endDate" cssStyle="font-weight: bold">Ngày kết thúc <span
                    style="color: red">(*)</span></form:label></div>
        <div style="width: 33.33%;float: left">
            <form:select path="endDate" cssStyle="width: 90%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${endDate}"  ></form:options>
            </form:select>
        </div>
        <div style="width: 33.33%;float: left">
            <form:select path="endMonth" cssStyle="width: 90%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${endMonth}"  ></form:options>
            </form:select>
        </div>
        <div style="width: 33.33%;float: left">
            <form:select path="endYear" cssStyle="width: 100%;height: 30px" >
                <form:option value="" label="--Chọn--"></form:option>
                <form:options items="${endYear}"  ></form:options>
            </form:select>
        </div>
    </div>
    <div>
        <form:label path="moved14day" cssStyle="font-weight: bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành
            phố nào? <span
                    style="color: red">(*)</span></form:label>
        <form:input path="moved14day" cssStyle="width: 100%;height: 60px"></form:input>
    </div>
    <br>
    <h4 style="font-weight: bold">Địa chỉ liên lạc</h4>
    <div style="width: 33.33%;float: left;">
        <form:label path="city" cssStyle="font-weight: bold">Tỉnh / thành <span
                style="color: red">(*)</span></form:label>
        <form:select path="city" cssStyle="width: 95%;height: 30px" >
            <form:option value="" label="--Chọn--"></form:option>
            <form:options items="${city}"  ></form:options>
        </form:select>
    </div>
    <div style="width: 33.33%;float: left;">
        <form:label path="district" cssStyle="font-weight: bold">Quận / huyện <span
                style="color: red">(*)</span></form:label>
        <form:select path="district" cssStyle="width: 95%;height: 30px" >
            <form:option value="" label="--Chọn--"></form:option>
            <form:options items="${district}"  ></form:options>
        </form:select>
    </div>
    <div style="width: 33.33%;float: left;">
        <form:label path="ward" cssStyle="font-weight: bold">Phường / xã <span
                style="color: red">(*)</span></form:label>
        <form:select path="ward" cssStyle="width: 100%;height: 30px" >
            <form:option value="" label="--Chọn--"></form:option>
            <form:options items="${ward}"  ></form:options>
        </form:select>
    </div>
    <div>
        <form:label path="symptom"
                    cssStyle="font-weight: bold">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau
            đây không? <span
                    style="color: red">(*)</span></form:label>
        <div style="width: 49%;float: left">
            <table border="1px" style="width: 100%">

                <tr style="height: 50px;background-color: lightblue">
                    <th style="width: 70%;padding-left: 10px">Triệu Chứng</th>
                    <th style="width: 15%;text-align: center">Có</th>
                    <th style="width: 15%;text-align: center">Không</th>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom" cssStyle="font-weight: bold">Sốt <span
                            style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom" value="Không"></form:radiobutton></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom1" cssStyle="font-weight: bold">
                        Ho <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom1" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom1" value="Không"></form:radiobutton></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom2" cssStyle="font-weight: bold">
                        Khó thở <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom2" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom2" value="Không"></form:radiobutton></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom3" cssStyle="font-weight: bold">
                        Đau họng <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom3" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom3" value="Không"></form:radiobutton></td>
                </tr>
            </table>
        </div>
        <div style="width: 49%;float: right">
            <table border="1px" style="width: 100%">

                <tr style="height: 50px;background-color: lightblue">
                    <th style="width: 70%;padding-left: 10px">Triệu Chứng</th>
                    <th style="width: 15%;text-align: center">Có</th>
                    <th style="width: 15%;text-align: center">Không</th>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom4" cssStyle="font-weight: bold">
                        Nôn / buồn nôn <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom4" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom4" value="Không"></form:radiobutton></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom5" cssStyle="font-weight: bold">
                        Tiêu chảy <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom5" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom5" value="Không"></form:radiobutton></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom6" cssStyle="font-weight: bold">
                        Xuất huyết ngoài da <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom6" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom6" value="Không"></form:radiobutton></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px"><form:label path="symptom7" cssStyle="font-weight: bold">
                        Nổi ban da ngoài <span style="color: red">(*)</span></form:label>
                    </td>
                    <td style="text-align: center"><form:radiobutton path="symptom7" value="Có"></form:radiobutton></td>
                    <td style="text-align: center"><form:radiobutton path="symptom7" value="Không"></form:radiobutton></td>
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
                <th style="width: 10%;text-align: center">Có</th>
                <th style="width: 10%;text-align: center">Không</th>
            </tr>
            <tr>
                <td style="padding-left: 10px"><form:label path="exposure"
                                                           cssStyle="font-weight: bold">Đến trang trại chăn nuôi / chợ
                    buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc động vật <span
                            style="color: red">(*)</span></form:label>
                </td>
                <td style="text-align: center"><form:radiobutton path="exposure" value="Có"></form:radiobutton></td>
                <td style="text-align: center"><form:radiobutton path="exposure" value="Không"></form:radiobutton></td>
            </tr>
            <tr>
                <td style="padding-left: 10px"><form:label path="exposure1" cssStyle="font-weight: bold">Tiếp xúc gần
                    (<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span
                            style="color: red">(*)</span></form:label>
                </td>
                <td style="text-align: center"><form:radiobutton path="exposure1" value="Có"></form:radiobutton></td>
                <td style="text-align: center"><form:radiobutton path="exposure1" value="Không"></form:radiobutton></td>
            </tr>
        </table>
    </div>
    <br>
    <p style="color: red;font-weight: bold">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống
        dịch, thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.
        Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>

        <button type="submit" style="margin: auto;display: block" class="btn btn-success">Gửi tờ khai</button>

</div>

</form:form>
</div>

</body>
</html>

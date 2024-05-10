document.getElementById('fecha').addEventListener('input', function (){
    fecha = '2024/05/10'
    idpista = document.getElementById('idpista').value()
    fetch('/horarios?fecha=' + fecha + '&idpista=' + idpista)
        .then(response => response.json())
        .then(data =>{
            div = document.getElementById('div')
            div.innerHTML = '<form class="row" th:action="@{/save}" method="post">\n' +
                '                        <div style="margin:10px" class="col-md-3 col-sm-6" th:each="horario : ${horarios}">\n' +
                '                            <input type="radio" class="btn-check" th:id="${horario}+\'btn-check\'" name="hora" th:value="${horario}">\n' +
                '                            <label class="btn btn-primary" th:for="${horario}+\'btn-check\'" th:text="${horario}"></label>\n' +
                '                        </div>\n' +
                '                        <input type="hidden" name="idpista" th:value="${idpista}">\n' +
                '                        <input type="hidden" name="fecha" th:value="${fecha}">\n' +
                '                        <input class="btn btn-success" type="submit" value="Reservar">\n' +
                '                    </form>'
        })
})
tableContainer = document.querySelector('.table-container');
table = document.createElement('table');
thead = document.createElement('thead');
tbody = document.createElement('tbody');
searchBtn = document.querySelector('#search-btn')
searchInput = document.querySelector('#inputKod')

const theadRow = thead.insertRow();
theadRow.innerHTML ='<th>Пользователь</th>\n'+
    '            <th>Возраст</th>\n'+
    '            <th>Город</th>\n'+
    '            <th>Почта</th>\n'+
    '            <th>Банк</th>\n'+
    '            <th>Дата</th>\n'

table.appendChild(thead);

searchBtn.addEventListener('click', () =>{
    const kod = searchInput.value;
    console.log(kod)
    getValuesByKod(kod)
})

function getValuesByKod(kod) {
    fetch(`/test/getValuesByKod?kod=${kod}`)
        .then(response => response.json())
        .then(data =>{
            tbody.innerHTML = '';
            data.forEach(request => {
                const row = tbody.insertRow();
                row.innerHTML =`<td>${request.name}</td>
                            <td>${request.age}</td>
                            <td>${request.city}</td>
                            <td>${request.email}</td>
                            <td>${request.nameBank}</td>
                            <td>${request.dateWrite}</td>`
                ;
            });
            table.appendChild(tbody);
            tableContainer.appendChild(table);
        })
        .catch(error => console.error('Ошибка получения данных:', error));
}



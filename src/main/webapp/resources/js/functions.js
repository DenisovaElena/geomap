// Получение названия по булевому полю
function getBulValue(data) {
    var value = 'Нет';
    if(data === true) {
        value = 'Да';
    }
    return value;
}
// Получение булевого значения по названию поля
function getBulValueRev(data) {
    var value = false;
    if(data === 'Да') {
        value = true;
    }
    return value;
}

// Отметка поля при корректировке
function getInputCheck(data,problem) {
    var value ='';
    var pos = data.indexOf("{") + 1;
    if(pos > 0) {
        value = "active";
    }
    return value;
}

// Получение поля при поступлении данных проблемы
function getProblemValue(data) {
    var value = data.replace('{','');
    value = value.replace('}' ,'');
    return value;
}

// Получение значения по булевому полю
/*function getNumberValue(data) {
    var value = 1;
    if(data === true) {
        value = 2;
    }
    return value;
}*/

// Запрос информации об объекте по ссылке и отображение информации в нижнем меню
function getObjectInfoBottom(url) {
    return $.getJSON (url, function(data) {
        $('#bottomMenuBlock').append('<div class="blockIn" data-block="1">\n' +
            '                <h2>Адрес</h2>\n' +
            '                <table>\n' +
            '                    <tr>\n' +
            '                        <td>Почтовый индекс:</td>\n' +
            '                        <td class="title">'+data.address.postcode+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Субъект РФ:</td>\n' +
            '                        <td class="title">'+data.address.region+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Тип населенного пункта:</td>\n' +
            '                        <td class="title">'+data.address.localityType+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Административный округ:</td>\n' +
            '                        <td class="title">'+data.address.admDistrict+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Район:</td>\n' +
            '                        <td class="title">'+data.address.district+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Населенный пункт:</td>\n' +
            '                        <td class="title">'+data.address.locality+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Тип улицы:</td>\n' +
            '                        <td class="title">'+data.address.street.streetType.name+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Улица:</td>\n' +
            '                        <td class="title">'+data.address.street.name+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Кадастровый номер земельного участка:</td>\n' +
            '                        <td class="title">'+data.address.landNum+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Номер здания/сооружения:</td>\n' +
            '                        <td class="title">'+getProblemValue(data.address.houseNum)+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Номер корпуса:</td>\n' +
            '                        <td class="title">'+data.address.buildNum+'</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Номер строения:</td>\n' +
            '                        <td class="title">'+data.address.consrNum+'</td>\n' +
            '                    </tr>\n' +
            '                </table>\n' +
            '            </div>' +
            '<div class="blockIn" data-block="2">\n' +
            '                    <h2>Технические характеристики</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь:</td>\n' +
            '                            <td class="title">'+data.techCharacter.area+' кв.м.</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Этажность:</td>\n' +
            '                            <td class="title">'+data.techCharacter.floorNum+'</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div class="blockIn" data-block="3">\n' +
            '                    <h2>Назначение</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <td>Назначение:</td>\n' +
            '                            <td class="title">'+data.buildingAssignment.assignment+'</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div class="blockIn" data-block="4">\n' +
            '                    <h2>Правообладание</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <td>Правообладатель:</td>\n' +
            '                            <td class="title">'+data.owner.permisOwner+'</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div class="blockIn" data-block="5">\n' +
            '                    <h2>Оценка объекта</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <td>Средняя кадастровая стоимость за 1 кв. м. помещения:</td>\n' +
            '                            <td class="title">'+data.costEvaluationId.adCadValRoom+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Средняя кадастровая стоимость за 1 кв. м. земельного участка:</td>\n' +
            '                            <td class="title">'+data.costEvaluationId.avCadValLand+' рублей</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div class="blockIn" data-block="6">\n' +
            '                    <h2>Стоимость владения</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <td>Холодное водоснабжение:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.coldWater+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Горячее водоснабжение:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.hotWater+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Водоотведение:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.waterDisp+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Отопление:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.heatSys+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Электроснабжение:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.electrosupply+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Газоснабжение:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.gasSupply+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Расходы на коммунальные услуги за 1 кв. м.:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.utilityCosts+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Налог на имущество за 1 кв. м.:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.wealthTax+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Земельный налог за 1 кв. м.:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.landTax+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Арендная плата за 1 кв. м.:</td>\n' +
            '                            <td class="title">'+data.costOfOwnership.rent+' рублей</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div class="blockIn" data-block="7">\n' +
            '                    <h2>Доходы бюджета</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <td>Налог на имущество</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.wealthTax+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Начислено:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.wealthTaxAccrued+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Поступило:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.wealthTaxRecieved+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Задолженность (свыше 3 мес.):</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.wealthTaxDebt+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Земельный налог</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.landTax+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Начислено:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.landTaxAccrued+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Поступило:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.landTaxReceived+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Задолженность (свыше 3 мес.):</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.landTaxDebt+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Арендная плата</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.rent+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Начислено:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.rentAccrued+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Поступило:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.rentReceived+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Задолженность (свыше 3 мес.):</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.rentDebt+' рублей</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь объектов во владении физических лиц</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.areaOwnersObjects+' кв. м</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь объектов попадающих под НДФЛ при реализации в текущем году:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.areaOwnObjNdfl+' кв. м</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь объектов попадающих под НДФЛ при реализации в текущем году, сменивших правообладателей:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.areaOwnersObjects+' кв. м</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Размер начисленного НДФЛ:</td>\n' +
            '                            <td class="title">'+data.budgetRevenues.ndfl+' рублей</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div class="blockIn" data-block="8">\n' +
            '                    <h2>Соблюдение законодательства</h2>\n' +
            '                    <table>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Проблемы с адресом</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Отсутствует адрес</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.addressIssuesNoAddress)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Неполный адрес</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.addressIssuesIncomplete)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Некорректный адрес</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.addressIssuesInvalid)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Проблемы с оформлением ЗПО</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ЗУ с недействующими ЗПО</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.landRegInactive)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ЗУ с недействующими ЗПО в неразграниченной собственности</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.landRegInactiveUnOwnership)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ОКС на несформированном ЗУ</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.landRegBuildAtNotFormedLand)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Самовольная застройка</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Несоответствие сведениям разрешительной документации</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.selfWilledBuildDocMismatch)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Нецелевое использование</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Несоответствие вывесок</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.misuseSignMismatch)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Самозахват</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Заборы вне границ ЗУ</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.squattingFencesOutsideLandBoundaries)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ОКС на непредставленном ЗУ, неразграничеенной или городской собственности</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.squattingBuildOnUnpresLand)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ОКС без прав</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.squattingBuildWithoutRights)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Превышение сроков строительства</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Превышение сроков строительства</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.timeExcess)+'</td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Ненадлежащее содержание</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Ненадлежащее содержание</td>\n' +
            '                            <td class="title">'+getBulValue(data.complianceWithLegislation.inappMaintenance)+'</td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>');
    })
}

// Запрос информации об объекте по ссылке и отображение информации в нижнем меню
function getObjectInfoRight(url) {
    return $.getJSON (url, function(data, problem) {
        $('#resizable').append('<button class="ui-button ui-widget ui-corner-all active">'+data.name+'</button>');
        $('#tabsTitle').html('Объект: '+data.name);
        var coordinates = data.coordinates.coordinates;
        $('#tabs').append('<div id="tabs-1">' +
            '<input type="hidden" id="addressId" value="'+data.address.id+'">' +
            '<input id="dataId" type="hidden" value="'+data.id+'">' +
            '<input id="dataName" type="hidden" value="'+data.name+'">' +
            '<input id="coordinatesType" type="hidden" value="'+data.coordinates.type+'">' +
            '                <h3>Адрес</h3>\n' +
            '                <table class="tabs">\n' +
            '                    <tr>\n' +
            '                        <td>Почтовый индекс:</td>\n' +
            '                        <td><input type="text" id="postcode" value="'+data.address.postcode+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Субъект РФ:</td>\n' +
            '                        <td><input type="text" id="region" value="'+data.address.region+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Тип населенного пункта:</td>\n' +
            '                        <td><input type="text" id="localityType" value="'+data.address.localityType+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Административный округ:</td>\n' +
            '                        <td><input type="text" id="admDistrict" value="'+data.address.admDistrict+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Район:</td>\n' +
            '                        <td><input type="text" id="district" value="'+data.address.district+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Населенный пункт:</td>\n' +
            '                        <td><input type="text" id="locality" value="'+data.address.locality+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Тип улицы:</td>\n' +
            '                        <td>' +
            '<input type="text" id="streetTypeName" value="'+data.address.street.streetType.name+'">' +
            '<input type="hidden" id="streetTypeId" value="'+data.address.street.streetType.id+'">' +
            '<input type="hidden" id="streetType" value="'+data.address.street.coordinates.type+'">' +
            '</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Улица:</td>\n' +
            '                        <td>' +
            '<input type="text" id="streetName" value="'+data.address.street.name+'">' +
            '<input type="hidden" id="streetId" value="'+data.address.street.id+'">' +
            '</td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Кадастровый номер земельного участка:</td>\n' +
            '                        <td><input type="text" id="landNum" value="'+data.address.landNum+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Номер здания/сооружения:</td>\n' +
            '                        <td><input type="text" id="houseNum" class="'+getInputCheck(data.address.houseNum)+'" value="'+getProblemValue(data.address.houseNum)+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Номер корпуса:</td>\n' +
            '                        <td><input type="text" id="buildNum" value="'+data.address.buildNum+'"></td>\n' +
            '                    </tr>\n' +
            '                    <tr>\n' +
            '                        <td>Номер строения:</td>\n' +
            '                        <td><input type="text" id="consrNum" value="'+data.address.consrNum+'"></td>\n' +
            '                    </tr>\n' +
            '                </table>\n' +
            '            </div>' +
            '<div id="tabs-2" style="display: none;" aria-hidden="true"><input type="hidden" id="techCharacterId" value="'+data.techCharacter.id+'">\n' +
            '                    <h2>Технические характеристики</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <td>Площадь, кв.м.:</td>\n' +
            '                            <td><input type="text" id="techCharacterArea" value="'+data.techCharacter.area+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Этажность:</td>\n' +
            '                            <td><input type="text" id="techCharacterFloorNum" value="'+data.techCharacter.floorNum+'"></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div id="tabs-3" style="display: none;" aria-hidden="true"><input type="hidden" id="buildingAssignmentId" value="'+data.buildingAssignment.id+'">\n' +
            '                    <h2>Назначение</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <td>Назначение:</td>\n' +
            '                            <td><input type="text" id="assignment" value="'+data.buildingAssignment.assignment+'"></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div id="tabs-4" style="display: none;" aria-hidden="true"><input type="hidden" id="ownerId" value="'+data.owner.id+'">\n' +
            '                    <h2>Правообладание</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <td>Правообладатель:</td>\n' +
            '                            <td><input type="text" id="permisOwner" value="'+data.owner.permisOwner+'"></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div id="tabs-5" style="display: none;" aria-hidden="true"><input type="hidden" id="costEvaluationId" value="'+data.costEvaluationId.id+'">\n' +
            '                    <h2>Оценка объекта</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <td>Средняя кадастровая стоимость за 1 кв. м. помещения, рублей:</td>\n' +
            '                            <td><input type="text" id="adCadValRoom" value="'+data.costEvaluationId.adCadValRoom+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Средняя кадастровая стоимость за 1 кв. м. земельного участка, рублей:</td>\n' +
            '                            <td><input type="text" id="avCadValLand" value="'+data.costEvaluationId.avCadValLand+'"></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div id="tabs-6" style="display: none;" aria-hidden="true"><input type="hidden" id="costOfOwnershipId" value="'+data.costOfOwnership.id+'">\n' +
            '                    <h2>Стоимость владения</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <td>Холодное водоснабжение, рублей:</td>\n' +
            '                            <td><input type="text" id="coldWater" value="'+data.costOfOwnership.coldWater+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Горячее водоснабжение, рублей:</td>\n' +
            '                            <td><input type="text" id="hotWater" value="'+data.costOfOwnership.hotWater+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Водоотведение, рублей:</td>\n' +
            '                            <td><input type="text" id="waterDisp" value="'+data.costOfOwnership.waterDisp+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Отопление, рублей:</td>\n' +
            '                            <td><input type="text" id="heatSys" value="'+data.costOfOwnership.heatSys+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Электроснабжение, рублей:</td>\n' +
            '                            <td><input type="text" id="electrosupply" value="'+data.costOfOwnership.electrosupply+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Газоснабжение, рублей:</td>\n' +
            '                            <td><input type="text" id="gasSupply" value="'+data.costOfOwnership.gasSupply+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Расходы на коммунальные услуги за 1 кв. м., рублей:</td>\n' +
            '                            <td><input type="text" id="utilityCosts" value="'+data.costOfOwnership.utilityCosts+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Налог на имущество за 1 кв. м., рублей:</td>\n' +
            '                            <td><input type="text" id="wealthTax" value="'+data.costOfOwnership.wealthTax+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Земельный налог за 1 кв. м., рублей:</td>\n' +
            '                            <td><input type="text" id="landTax" value="'+data.costOfOwnership.landTax+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Арендная плата за 1 кв. м., рублей:</td>\n' +
            '                            <td><input type="text" id="rent" value="'+data.costOfOwnership.rent+'"></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div id="tabs-7" style="display: none;" aria-hidden="true"><input type="hidden" id="budgetRevenues" value="'+data.budgetRevenues.id+'">\n' +
            '                    <h2>Доходы бюджета</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <td>Налог на имущество, рублей</td>\n' +
            '                            <td><input type="text" id="budgetWealthTax" value="'+data.budgetRevenues.wealthTax+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Начислено, рублей:</td>\n' +
            '                            <td><input type="text" id="wealthTaxAccrued" value="'+data.budgetRevenues.wealthTaxAccrued+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Поступило, рублей:</td>\n' +
            '                            <td><input type="text" id="wealthTaxRecieved" value="'+data.budgetRevenues.wealthTaxRecieved+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Задолженность (свыше 3 мес.), рублей:</td>\n' +
            '                            <td><input type="text" id="wealthTaxDebt" value="'+data.budgetRevenues.wealthTaxDebt+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Земельный налог, рублей:</td>\n' +
            '                            <td><input type="text" id="budgetLandTax" value="'+data.budgetRevenues.landTax+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Начислено, рублей:</td>\n' +
            '                            <td><input type="text" id="landTaxAccrued" value="'+data.budgetRevenues.landTaxAccrued+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Поступило, рублей:</td>\n' +
            '                            <td><input type="text" id="landTaxReceived" value="'+data.budgetRevenues.landTaxReceived+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Задолженность (свыше 3 мес.), рублей:</td>\n' +
            '                            <td><input type="text" id="landTaxDebt" value="'+data.budgetRevenues.landTaxDebt+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Арендная плата, рублей</td>\n' +
            '                            <td><input type="text" id="budgetRent" value="'+data.budgetRevenues.rent+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Начислено, рублей:</td>\n' +
            '                            <td><input type="text" id="rentAccrued" value="'+data.budgetRevenues.rentAccrued+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Поступило, рублей:</td>\n' +
            '                            <td><input type="text" id="rentReceived" value="'+data.budgetRevenues.rentReceived+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Задолженность (свыше 3 мес.), рублей:</td>\n' +
            '                            <td><input type="text" id="rentDebt" value="'+data.budgetRevenues.rentDebt+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь объектов во владении физических лиц, кв. м</td>\n' +
            '                            <td><input type="text" id="areaOwnersObjects" value="'+data.budgetRevenues.areaOwnersObjects+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь объектов попадающих под НДФЛ при реализации в текущем году, кв. м:</td>\n' +
            '                            <td><input type="text" id="areaOwnObjNdfl" value="'+data.budgetRevenues.areaOwnObjNdfl+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Площадь объектов попадающих под НДФЛ при реализации в текущем году, сменивших правообладателей, кв. м:</td>\n' +
            '                            <td><input type="text" id="areaOwnObjNdflChanOwn" value="'+data.budgetRevenues.areaOwnObjNdflChanOwn+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Размер начисленного НДФЛ, рублей:</td>\n' +
            '                            <td><input type="text" id="ndfl" value="'+data.budgetRevenues.ndfl+'"></td>\n' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>' +
            '<div id="tabs-8" style="display: none;" aria-hidden="true"><input type="hidden" id="complianceWithLegislation" value="'+data.complianceWithLegislation.id+'">\n' +
            '                    <h2>Соблюдение законодательства</h2>\n' +
            '                    <table class="tabs">\n' +
            '                        <tr>\n' +
            '                            <!--<td colspan="2" class="center"><h3>Проблемы с адресом</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Отсутствует адрес</td>\n' +
            '                            <td><input type="text" id="addressIssuesNoAddress" value="'+getBulValue(data.complianceWithLegislation.addressIssuesNoAddress)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Неполный адрес</td>\n' +
            '                            <td><input type="text" id="addressIssuesIncomplete" value="'+getBulValue(data.complianceWithLegislation.addressIssuesIncomplete)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Некорректный адрес</td>\n' +
            '                            <td><input type="text" id="addressIssuesInvalid" value="'+getBulValue(data.complianceWithLegislation.addressIssuesInvalid)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <input type="hidden" id="commentAddressIssues" value="'+data.complianceWithLegislation.addressIssuesInvalid+'"><!--<td colspan="2" class="center"><h3>Проблемы с оформлением ЗПО</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ЗУ с недействующими ЗПО</td>\n' +
            '                            <td><input type="text" id="landRegInactive" value="'+getBulValue(data.complianceWithLegislation.landRegInactive)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ЗУ с недействующими ЗПО в неразграниченной собственности</td>\n' +
            '                            <td><input type="text" id="landRegInactiveUnOwnership" value="'+getBulValue(data.complianceWithLegislation.landRegInactiveUnOwnership)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ОКС на несформированном ЗУ</td>\n' +
            '                            <td><input type="text" id="landRegBuildAtNotFormedLand" value="'+getBulValue(data.complianceWithLegislation.landRegBuildAtNotFormedLand)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <input type="hidden" id="commentLandReg" value="'+data.complianceWithLegislation.commentLandReg+'"><!--<td colspan="2" class="center"><h3>Самовольная застройка</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Несоответствие сведениям разрешительной документации</td>\n' +
            '                            <td><input type="text" id="selfWilledBuildDocMismatch" value="'+getBulValue(data.complianceWithLegislation.selfWilledBuildDocMismatch)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <input type="hidden" id="commentSelfWilledBuild" value="'+data.complianceWithLegislation.commentSelfWilledBuild+'"><!--<td colspan="2" class="center"><h3>Нецелевое использование</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Несоответствие вывесок</td>\n' +
            '                            <td><input type="text" id="misuseSignMismatch" value="'+getBulValue(data.complianceWithLegislation.misuseSignMismatch)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <input type="hidden" id="commentMisuse" value="'+data.complianceWithLegislation.commentMisuse+'"><!--<td colspan="2" class="center"><h3>Самозахват</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Заборы вне границ ЗУ</td>\n' +
            '                            <td><input type="text" id="squattingFencesOutsideLandBoundaries" value="'+getBulValue(data.complianceWithLegislation.squattingFencesOutsideLandBoundaries)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ОКС на непредставленном ЗУ, неразграничеенной или городской собственности</td>\n' +
            '                            <td><input type="text" id="squattingBuildOnUnpresLand" value="'+getBulValue(data.complianceWithLegislation.squattingBuildOnUnpresLand)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>ОКС без прав</td>\n' +
            '                            <td><input type="text" id="squattingBuildWithoutRights" value="'+getBulValue(data.complianceWithLegislation.squattingBuildWithoutRights)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <input type="hidden" id="commentSquatting" value="'+data.complianceWithLegislation.timeExcess+'"><!--<td colspan="2" class="center"><h3>Превышение сроков строительства</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Превышение сроков строительства</td>\n' +
            '                            <td><input type="text" id="timeExcess" value="'+getBulValue(data.complianceWithLegislation.timeExcess)+'"></td>\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <input type="hidden" id="commentTimeExcess" value="'+data.complianceWithLegislation.commentTimeExcess+'"><!--<td colspan="2" class="center"><h3>Ненадлежащее содержание</h3></td>-->\n' +
            '                        </tr>\n' +
            '                        <tr>\n' +
            '                            <td>Ненадлежащее содержание</td>\n' +
            '                            <td><input type="text" id="inappMaintenance" value="'+getBulValue(data.complianceWithLegislation.inappMaintenance)+'"></td>\n' +
            '                            <input type="hidden" id="commentInappMaintenance" value="'+data.complianceWithLegislation.commentInappMaintenance+'">' +
            '                        </tr>\n' +
            '                    </table>\n' +
            '                </div>');
    })
}

// Формирование массива объектов редактирования
function objectArray(url) {
    return $.getJSON (url, function(data) {
        for(var i in data) {
            var objectMarkers = {
                "id" : data.id,
                "name" : data.name,
                /*"coordinates" : {
                    "long" : data.centerCoordinates.coordinates[0],
                    "lang" : data.centerCoordinates.coordinates[1]
                }*/
            }
        }
    });
}

// Формирование стека для сохранения карточки
function createJSON() {
    var valueObj = {
        "id" : $('#dataId').val(),
        "name" : $('#dataName').val(),
        /*"coordinates" : {
            "type" : $('#coordinatesType').val(),
            /!*"coordinates" : [],*!/
        },*/
        "techCharacter" : {
            "id" : $('#techCharacterId').val(),
            "area" : $('#techCharacterArea').val(),
            "floorNum" : $('#techCharacterFloorNum').val(),
        },
        "address" : {
            "id" : $('#addressId').val(),
            "postcode" : $('#postcode').val(),
            "region" : $('#region').val(),
            "admDistrict" : $('#admDistrict').val(),
            "district" : $('#district').val(),
            "localityType" : $('#localityType').val(),
            "locality" : $('#locality').val(),
            "houseNum" : $('#houseNum').val(),
            "buildNum" : $('#buildNum').val(),
            "consrNum" : $('#consrNum').val(),
            "landNum" : $('#landNum').val(),
            "street" : {
                "id" : $('#streetId').val(),
                "name" : $('#streetName').val(),
                /*"coordinates" : {
                    "type" : $('#streetType').val(),
                    /!*"coordinates" : [],*!/
                },*/
                "streetType" : {
                    "id" : $('#streetTypeId').val(),
                    "name" : $('#streetTypeName').val(),
                },
            },
        },
        "buildingAssignment" : {
            "id" : $('#buildingAssignmentId').val(),
            "assignment" : $('#assignment').val(),
        },
        "owner" : {
            "id" : $('#ownerId').val(),
            "permisOwner" : $('#permisOwner').val(),
        },
        "costEvaluationId" : {
            "id" : $('#costEvaluationId').val(),
            "adCadValRoom" : $('#adCadValRoom').val(),
            "avCadValLand" : $('#avCadValLand').val(),
        },
        "costOfOwnership" : {
            "id" : $('#costOfOwnershipId').val(),
            "hotWater" : $('#hotWater').val(),
            "coldWater" : $('#coldWater').val(),
            "waterDisp" : $('#waterDisp').val(),
            "heatSys" : $('#heatSys').val(),
            "electrosupply" : $('#electrosupply').val(),
            "gasSupply" : $('#gasSupply').val(),
            "utilityCosts" : $('#utilityCosts').val(),
            "wealthTax" : $('#wealthTax').val(),
            "landTax" : $('#landTax').val(),
            "rent" : $('#rent').val(),
        },
        "complianceWithLegislation" : {
            "id" : $('#complianceWithLegislation').val(),
            "addressIssuesNoAddress" : getBulValueRev($('#addressIssuesNoAddress').val()),
            "addressIssuesIncomplete" : getBulValueRev($('#addressIssuesIncomplete').val()),
            "addressIssuesInvalid" : getBulValueRev($('#addressIssuesInvalid').val()),
            "commentAddressIssues" : $('#commentAddressIssues').val(),
            "landRegInactive" : getBulValueRev($('#landRegInactive').val()),
            "landRegInactiveUnOwnership" : getBulValueRev($('#landRegInactiveUnOwnership').val()),
            "landRegBuildAtNotFormedLand" : getBulValueRev($('#landRegBuildAtNotFormedLand').val()),
            "commentLandReg" : $('#commentLandReg').val(),
            "selfWilledBuildDocMismatch" : getBulValueRev($('#selfWilledBuildDocMismatch').val()),
            "commentSelfWilledBuild" : $('#commentSelfWilledBuild').val(),
            "misuseSignMismatch" : getBulValueRev($('#misuseSignMismatch').val()),
            "commentMisuse" : $('#commentMisuse').val(),
            "squattingFencesOutsideLandBoundaries" : getBulValueRev($('#squattingFencesOutsideLandBoundaries').val()),
            "squattingBuildOnUnpresLand" : getBulValueRev($('#squattingBuildOnUnpresLand').val()),
            "squattingBuildWithoutRights" : getBulValueRev($('#squattingBuildWithoutRights').val()),
            "commentSquatting" : $('#commentSquatting').val(),
            "timeExcess" : getBulValueRev($('#timeExcess').val()),
            "commentTimeExcess" : $('#commentTimeExcess').val(),
            "inappMaintenance" : getBulValueRev($('#inappMaintenance').val()),
            "commentInappMaintenance" : $('#commentInappMaintenance').val(),
        },
        "budgetRevenues" : {
            "id" : $('#budgetRevenues').val(),
            "wealthTax" : $('#budgetWealthTax').val(),
            "wealthTaxAccrued" : $('#wealthTaxAccrued').val(),
            "wealthTaxRecieved" : $('#wealthTaxRecieved').val(),
            "wealthTaxDebt" : $('#wealthTaxDebt').val(),
            "landTax" : $('#budgetLandTax').val(),
            "landTaxAccrued" : $('#landTaxAccrued').val,
            "landTaxReceived" : $('#landTaxReceived').val(),
            "landTaxDebt" : $('#landTaxDebt').val(),
            "rent" : $('#budgetRent').val(),
            "rentAccrued" : $('#rentAccrued').val(),
            "rentReceived" : $('#rentReceived').val(),
            "rentDebt" : $('#rentDebt').val(),
            "areaOwnersObjects" : $('#areaOwnersObjects').val(),
            "areaOwnObjNdfl" : $('#areaOwnObjNdfl').val(),
            "areaOwnObjNdflChanOwn" : $('#areaOwnObjNdflChanOwn').val(),
            "ndfl" : $('#ndfl').val(),
        },
    }
    return valueObj;
}
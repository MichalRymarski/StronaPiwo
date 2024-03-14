# <div style="font-size:1.5em;">Notatki do Spring Security</div>
### [link do md](https://www.markdownguide.org/basic-syntax/)
### [link do tego jak grafy robic](https://mermaid.js.org/intro/syntax-reference.html)

# <div style="color:Purple;">Teoria :</div>
### Authentification & Authorization<br/>
 Authentification = kim jestes <br/>
 Autorization = co możesz robic

### AUTHRORITY = akcje ktore mozesz wykonywac
np. CREATE_USER, LOG_IN
### ROLE = zbior twoich permisjii
### PRINCIPAL = info o zalogowanym userze
### FILTRY
Filtry są po to żebyś był najpierw sprawdzony czy istniejsz i czy masz pozwolenia na zrobienie czegos<br/>
zanim dotrzesz do logiki

### DATASOURCE <br/>
Datasource to źródło pobierania danych o użytkowniku, <br/>
który chce się zalogować  u nas tym źródłem jest baza danych.<br/>
**NIE** trzeba robic implementacji DataSource w kodzie jesli ma sie to w pliku <br/>
[application.properties](application.properties)

## FILTRY SECURITY**<br/>
[Link do filmiku opisującego teorie](https://youtu.be/caCJAJC41Rk?si=_Cciv1DGFa2CrmEf)<br/>
### TLDR: <br/>
1. Ktoś chce dostać do czegoś dostęp
2. Wysłane jest info o tym do **IMPLEMENTACJI** AuthenticationManagera
3.  AuthenticationManager pyta każdego AuthenticationProvidera **po kolei**<br/> którego mamy zaimplementowanego w kodzie o to czy ten ktoś jest gitem
4. Jeśli AuthenticationProvider wykona metode `authenticate()` prawidłowo to zwraca info o tym, że ten ktoś jest gitem.<br/>
Jeśli żaden AuthenticationProvider nie zwróci info to AuthentificationManager nie zwraca `PRINCIPAL` użytkownika i dostęp kończy się niepowodzeniem.
5. Jeśli udało się Providerowi sprawdzić użytkownika z powodzeniem AuthentificationManager zwraca ``PRINCIPAL``  do chłopka co zażyczył dostępu.
<br/><br/>
[Artykuł do Filtrów z medium](https://medium.com/@tanmaysaxena2904/spring-security-the-security-filter-chain-e09e1f53b73d) <br/>
![img.png](img.png)<br/>


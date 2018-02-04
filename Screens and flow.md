#####Welcome screen (create account/log in)
JSP to display form 
<br />Servlet to process results passed in (create new user, add to db)

#####Login for existing users
JSP to display login form
<br />Servlet to process login (compare against db, etc)

#####New user welcome
JSP for Welcome
<br />Servlet to send to Sync all Connections or Choose Connections to Sync

#####Sync all/refresh
JSP for sync all/refresh
<br />Servlet to handle the synchronization
<br />(Redirects to Existing User Login)

#####Selective sync
JSP for form data
<br />Servlet to handle search, form validation & synchronization
<br />(Redirects to Existing User Login) -- screen to display results being brought in?
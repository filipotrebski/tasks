call runcrud goto display

:display
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto fail
goto end

:fail
echo.
echo Errors
goto end

:end
echo.
echo Work is finished
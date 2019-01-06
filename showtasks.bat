call runcrud
if "%ERRORLEVEL%" == "0" goto display
goto fail

:display
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
goto fail

:fail
echo.
echo Errors
goto end

:end
echo.
echo Work is finished
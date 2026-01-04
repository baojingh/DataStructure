
push:
	git pull
	git add . || true
	git commit -m "update" || true
	git push origin main || true

package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    private static void closeQuietly(java.lang.AutoCloseable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        goto L_0x0008;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.TreeDocumentFile.closeQuietly(java.lang.AutoCloseable):void");
    }

    private static android.net.Uri createFile(android.content.Context r0, android.net.Uri r1, java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x0009 }
        r0 = android.provider.DocumentsContract.createDocument(r0, r1, r2, r3);	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.TreeDocumentFile.createFile(android.content.Context, android.net.Uri, java.lang.String, java.lang.String):android.net.Uri");
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    public DocumentFile createDirectory(String str) {
        Uri createFile = createFile(this.mContext, this.mUri, "vnd.android.document/directory", str);
        return createFile != null ? new TreeDocumentFile(this, this.mContext, createFile) : null;
    }

    public DocumentFile createFile(String str, String str2) {
        Uri createFile = createFile(this.mContext, this.mUri, str, str2);
        return createFile != null ? new TreeDocumentFile(this, this.mContext, createFile) : null;
    }

    public boolean delete() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.mContext;	 Catch:{ Exception -> 0x000d }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x000d }
        r1 = r2.mUri;	 Catch:{ Exception -> 0x000d }
        r0 = android.provider.DocumentsContract.deleteDocument(r0, r1);	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.TreeDocumentFile.delete():boolean");
    }

    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    public DocumentFile[] listFiles() {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Uri uri = this.mUri;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        AutoCloseable autoCloseable = null;
        try {
            autoCloseable = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
            while (autoCloseable.moveToNext()) {
                arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, autoCloseable.getString(0)));
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed query: ");
            stringBuilder.append(e);
            Log.w("DocumentFile", stringBuilder.toString());
        } catch (Throwable th) {
            closeQuietly(null);
        }
        closeQuietly(autoCloseable);
        Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
        DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
        while (i < uriArr.length) {
            documentFileArr[i] = new TreeDocumentFile(this, this.mContext, uriArr[i]);
            i++;
        }
        return documentFileArr;
    }

    public boolean renameTo(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.mContext;	 Catch:{ Exception -> 0x0013 }
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x0013 }
        r2 = r3.mUri;	 Catch:{ Exception -> 0x0013 }
        r4 = android.provider.DocumentsContract.renameDocument(r1, r2, r4);	 Catch:{ Exception -> 0x0013 }
        if (r4 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0013 }
    L_0x000f:
        r3.mUri = r4;	 Catch:{ Exception -> 0x0013 }
        r4 = 1;
        return r4;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.TreeDocumentFile.renameTo(java.lang.String):boolean");
    }
}

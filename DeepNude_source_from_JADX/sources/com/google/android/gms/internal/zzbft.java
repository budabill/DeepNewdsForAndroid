package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger.zza;
import com.google.android.gms.phenotype.Phenotype;
import com.google.android.gms.phenotype.PhenotypeFlag;
import com.google.android.gms.phenotype.PhenotypeFlag.Factory;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class zzbft implements zza {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Factory zzfqj = new Factory(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).withGservicePrefix("gms:playlog:service:sampling_").withPhenotypePrefix("LogSampling__");
    private static Map<String, PhenotypeFlag<String>> zzfqk = null;
    private static Boolean zzfql = null;
    private static Long zzfqm = null;
    private final Context zzaiq;

    public zzbft(Context context) {
        this.zzaiq = context;
        if (zzfqk == null) {
            zzfqk = new HashMap();
        }
        context = this.zzaiq;
        if (context != null) {
            PhenotypeFlag.maybeInit(context);
        }
    }

    private static boolean zzcc(Context context) {
        if (zzfql == null) {
            zzfql = Boolean.valueOf(zzbih.zzdd(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzfql.booleanValue();
    }

    private static zzbfu zzge(String str) {
        if (str == null) {
            return null;
        }
        String str2;
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            indexOf++;
            str2 = substring;
        } else {
            str2 = "";
            indexOf = 0;
        }
        int indexOf2 = str.indexOf(47, indexOf);
        String str3 = "LogSamplerImpl";
        if (indexOf2 <= 0) {
            String str4 = "Failed to parse the rule: ";
            str = String.valueOf(str);
            Log.e(str3, str.length() != 0 ? str4.concat(str) : new String(str4));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(indexOf, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0) {
                if (parseLong2 >= 0) {
                    return new zzbfu(str2, parseLong, parseLong2);
                }
            }
            StringBuilder stringBuilder = new StringBuilder(72);
            stringBuilder.append("negative values not supported: ");
            stringBuilder.append(parseLong);
            stringBuilder.append("/");
            stringBuilder.append(parseLong2);
            Log.e(str3, stringBuilder.toString());
            return null;
        } catch (Throwable e) {
            substring = "parseLong() failed while parsing: ";
            str = String.valueOf(str);
            Log.e(str3, str.length() != 0 ? substring.concat(str) : new String(substring), e);
            return null;
        }
    }

    public final boolean zzg(String str, int i) {
        String str2 = null;
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        Context context = this.zzaiq;
        if (context != null) {
            if (zzcc(context)) {
                PhenotypeFlag phenotypeFlag = (PhenotypeFlag) zzfqk.get(str);
                if (phenotypeFlag == null) {
                    phenotypeFlag = zzfqj.createFlag(str, null);
                    zzfqk.put(str, phenotypeFlag);
                }
                str2 = (String) phenotypeFlag.get();
            }
        }
        zzbfu zzge = zzge(str2);
        if (zzge == null) {
            return true;
        }
        long j;
        long zzi;
        long j2;
        long j3;
        StringBuilder stringBuilder;
        str2 = zzge.zzfqn;
        context = this.zzaiq;
        if (zzfqm == null) {
            if (context != null) {
                zzfqm = zzcc(context) ? Long.valueOf(zzdnm.getLong(context.getContentResolver(), "android_id", 0)) : Long.valueOf(0);
            } else {
                j = 0;
                if (str2 != null) {
                    if (str2.isEmpty()) {
                        byte[] bytes = str2.getBytes(UTF_8);
                        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
                        allocate.put(bytes);
                        allocate.putLong(j);
                        zzi = zzbfo.zzi(allocate.array());
                        j2 = zzge.zzfqo;
                        j3 = zzge.zzfqp;
                        if (j2 >= 0 || j3 < 0) {
                            stringBuilder = new StringBuilder(72);
                            stringBuilder.append("negative values not supported: ");
                            stringBuilder.append(j2);
                            stringBuilder.append("/");
                            stringBuilder.append(j3);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        if (j3 > 0) {
                            if ((zzi >= 0 ? zzi % j3 : (((Long.MAX_VALUE % j3) + 1) + ((zzi & Long.MAX_VALUE) % j3)) % j3) < j2) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                zzi = zzbfo.zzi(ByteBuffer.allocate(8).putLong(j).array());
                j2 = zzge.zzfqo;
                j3 = zzge.zzfqp;
                if (j2 >= 0) {
                }
                stringBuilder = new StringBuilder(72);
                stringBuilder.append("negative values not supported: ");
                stringBuilder.append(j2);
                stringBuilder.append("/");
                stringBuilder.append(j3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        j = zzfqm.longValue();
        if (str2 != null) {
            if (str2.isEmpty()) {
                byte[] bytes2 = str2.getBytes(UTF_8);
                ByteBuffer allocate2 = ByteBuffer.allocate(bytes2.length + 8);
                allocate2.put(bytes2);
                allocate2.putLong(j);
                zzi = zzbfo.zzi(allocate2.array());
                j2 = zzge.zzfqo;
                j3 = zzge.zzfqp;
                if (j2 >= 0) {
                }
                stringBuilder = new StringBuilder(72);
                stringBuilder.append("negative values not supported: ");
                stringBuilder.append(j2);
                stringBuilder.append("/");
                stringBuilder.append(j3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        zzi = zzbfo.zzi(ByteBuffer.allocate(8).putLong(j).array());
        j2 = zzge.zzfqo;
        j3 = zzge.zzfqp;
        if (j2 >= 0) {
        }
        stringBuilder = new StringBuilder(72);
        stringBuilder.append("negative values not supported: ");
        stringBuilder.append(j2);
        stringBuilder.append("/");
        stringBuilder.append(j3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
